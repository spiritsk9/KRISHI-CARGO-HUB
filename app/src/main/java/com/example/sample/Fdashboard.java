package com.example.sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sample.Common.Common;
import com.example.sample.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Fdashboard extends AppCompatActivity {
    ImageButton myImageButton1, myImageButton2, myImageButton3, myImageButton4 ,myImageButton5, myImageButton6;
    private Button signOut;
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;

    public TextView profile_name,  profile_mobile;
    FirebaseStorage storage;
    StorageReference storageReference;
    User newUser;
    FirebaseDatabase db;
    DatabaseReference user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fdashboard);



        myImageButton1 = (ImageButton) findViewById(R.id.postload);
        myImageButton2 = (ImageButton) findViewById(R.id.accepted_load);
        myImageButton3 = (ImageButton) findViewById(R.id.total_orders);
        myImageButton4 = (ImageButton) findViewById(R.id.feedback);
        myImageButton5 = (ImageButton) findViewById(R.id.profile);
        myImageButton6 = (ImageButton) findViewById(R.id.aboutus);

        signOut = (Button) findViewById(R.id.sign_out);
        db = FirebaseDatabase.getInstance();

        user = db.getReference("User").child(Common.currentUser.getMobile());
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        loadProfile();


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");


        myImageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beach = new Intent(Fdashboard.this, FarmerMapActivity.class);
                startActivity(beach);


            }
        });

        myImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beach = new Intent(Fdashboard.this, AcceptedLoad.class);
                startActivity(beach);


            }
        });

        myImageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beach = new Intent(Fdashboard.this, FeedBack.class);
                startActivity(beach);

            }
        });

        myImageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beach = new Intent(Fdashboard.this, FarmerProfile.class);
                startActivity(beach);

            }
        });

        myImageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beach = new Intent(Fdashboard.this, AboutUs.class);
                startActivity(beach);

            }
        });

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beach = new Intent(Fdashboard.this, MainActivity.class);
                startActivity(beach);

            }
        });


    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        Toast.makeText(Fdashboard.this,"There is no back action",Toast.LENGTH_LONG).show();
        return;
    }

    public void loadProfile() {

        profile_name = (TextView) findViewById(R.id.user_name);
        profile_mobile = (TextView) findViewById(R.id.user_id);


        profile_name.setText(Common.currentUser.getName());
        profile_mobile.setText(Common.currentUser.getMobile());

    }






}




