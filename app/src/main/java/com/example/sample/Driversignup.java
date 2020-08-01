package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.app.ProgressDialog;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;
import android.widget.TextView;
import android.util.Patterns;

import com.example.sample.Model.User;
import com.example.sample.Model.Driver;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Driversignup extends AppCompatActivity {

    EditText edtName,edtPhone,edtEmail,edtVehicle,edtLicense,edtPassword;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driversignup);

        edtName = (EditText)findViewById(R.id.text1);
        edtPhone = (EditText)findViewById(R.id.mobile);
        edtEmail = (EditText)findViewById(R.id.text5);
        edtVehicle = (EditText)findViewById(R.id.text6);
        edtLicense = (EditText)findViewById(R.id.text7);
        edtPassword = (EditText)findViewById(R.id.password);
        btnSignUp = (Button)findViewById(R.id.register);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("Driver");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(Driversignup.this);
                progressDialog.setMessage("Please wait..!");
                progressDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(edtPhone.getText().toString()).exists()){
                            progressDialog.dismiss();
                            Toast.makeText(Driversignup.this,"Driver already exists!",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            progressDialog.dismiss();
                            Driver driver = new Driver(edtName.getText().toString(),edtEmail.getText().toString(),edtVehicle.getText().toString(),edtLicense.getText().toString(),edtPassword.getText().toString());
                            table_user.child(edtPhone.getText().toString()).setValue(driver);
                            Toast.makeText(Driversignup.this,"SignUp successfully! " ,Toast.LENGTH_SHORT).show();
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
