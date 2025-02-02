package com.example.sample;
import android.app.ProgressDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

import com.example.sample.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Farmersignup extends AppCompatActivity {
 EditText edtName,edtPhone,edtEmail,edtAddress,edtPincode,edtPassword;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmersignup);

        edtName = (EditText)findViewById(R.id.text1);
        edtPhone = (EditText)findViewById(R.id.femail);
        edtEmail = (EditText)findViewById(R.id.text5);
        edtAddress = (EditText)findViewById(R.id.text6);
        edtPincode = (EditText)findViewById(R.id.text7);
        edtPassword = (EditText)findViewById(R.id.text10);
        btnSignUp = (Button)findViewById(R.id.fregister);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(Farmersignup.this);
                progressDialog.setMessage("Please wait..!");
                progressDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(edtPhone.getText().toString()).exists()){
                            progressDialog.dismiss();
                            Toast.makeText(Farmersignup.this,"User already exists!",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            progressDialog.dismiss();
                            User user = new User(edtName.getText().toString(),edtEmail.getText().toString(),edtAddress.getText().toString(),edtPincode.getText().toString(),edtPassword.getText().toString());
                            table_user.child(edtPhone.getText().toString()).setValue(user);
                            Toast.makeText(Farmersignup.this,"SignUp successfully! " ,Toast.LENGTH_SHORT).show();
                            finish();

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
