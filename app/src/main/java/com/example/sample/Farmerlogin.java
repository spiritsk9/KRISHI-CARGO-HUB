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


public class Farmerlogin extends AppCompatActivity {
    EditText edtPhone,edtPassword;
    Button btnSignIn, btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmerlogin);

        edtPhone = (EditText)findViewById(R.id.text1);
        edtPassword = (EditText)findViewById(R.id.text2);

        btnSignIn = (Button)findViewById(R.id.floginbutton);
        btnSignUp = (Button)findViewById(R.id.fsignupbutton);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");

                Intent farmerlogin = new Intent(getApplicationContext(), Farmersignup.class);
                startActivity(farmerlogin);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(Farmerlogin.this);
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
                              //  Toast.makeText(Farmerlogin.this, "Welcome to Krishi Cargo Hub..!", Toast.LENGTH_SHORT).show();
                                Intent home = new Intent(Farmerlogin.this,Fdashboard.class);
                                Common.currentUser = user;
                                startActivity(home);
                                finish();
                            } else {
                                Toast.makeText(Farmerlogin.this, "Phone no. or Password is incorrect..", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            progressDialog.dismiss();
                            Toast.makeText(Farmerlogin.this, "Please Sign Up First..!",Toast.LENGTH_SHORT).show();
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
