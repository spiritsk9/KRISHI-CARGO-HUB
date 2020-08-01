package com.example.sample;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sample.Common.Common;
import com.example.sample.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Driverlogin extends AppCompatActivity {
    EditText edtPhone,edtPassword;
    Button btnSignIn, btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driverlogin);

        edtPhone = (EditText)findViewById(R.id.text1);
        edtPassword = (EditText)findViewById(R.id.text2);

        btnSignIn = (Button)findViewById(R.id.dloginbutton);
        btnSignUp = (Button)findViewById(R.id.dsignupbutton);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("Driver");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");

                Intent farmerlogin = new Intent(getApplicationContext(), Driversignup.class);
                startActivity(farmerlogin);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(Driverlogin.this);
                progressDialog.setMessage("Please wait!");
                progressDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(edtPhone.getText().toString()).exists()) {

                            progressDialog.dismiss();

                            User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
                            user.setMobile(edtPhone.getText().toString());
                            if (user.getPassword().equals(edtPassword.getText().toString())) {
                                //Toast.makeText(Farmerlogin.this, "Welcome to Krishi Cargo Hub..!", Toast.LENGTH_SHORT).show();
                                Intent home = new Intent(Driverlogin.this,Ddashboard.class);
                                Common.currentUser = user;
                                startActivity(home);
                                finish();
                            } else {
                                Toast.makeText(Driverlogin.this, "Phone no. or Password is incorrect..", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            progressDialog.dismiss();
                            Toast.makeText(Driverlogin.this, "Please Sign Up First..!",Toast.LENGTH_SHORT).show();
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
