package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import android.os.Bundle;

import com.example.sample.Common.Common;
import com.example.sample.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Ddashboard extends AppCompatActivity {
    private Button signOut;

    ImageButton myImageButton1, myImageButton2, myImageButton3, myImageButton4 ,myImageButton5, myImageButton6;

    public TextView profile_name,  profile_mobile;
    FirebaseStorage storage;
    StorageReference storageReference;
    User newUser;
    FirebaseDatabase db;
    DatabaseReference user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ddashboard);

        //get firebase auth instance


        //get current user

        myImageButton1 = (ImageButton) findViewById(R.id.postload);
        myImageButton2 = (ImageButton) findViewById(R.id.accepted_load);
        myImageButton3 = (ImageButton) findViewById(R.id.total_orders);
        myImageButton4 = (ImageButton) findViewById(R.id.feedback);
        myImageButton5 = (ImageButton) findViewById(R.id.profile);
        myImageButton6 = (ImageButton) findViewById(R.id.aboutus);

        signOut = (Button) findViewById(R.id.sign_out);
        db = FirebaseDatabase.getInstance();

        user = db.getReference("Driver").child(Common.currentUser.getMobile());
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        loadProfile();


        myImageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beach = new Intent(Ddashboard.this, DriverMapActivity.class);
                startActivity(beach);

            }
        });

        myImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beach = new Intent(Ddashboard.this, RequestList.class);
                startActivity(beach);

            }
        });

        myImageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beach = new Intent(Ddashboard.this, FeedBack.class);
                startActivity(beach);

            }
        });

        myImageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beach = new Intent(Ddashboard.this, DriverProfile.class);
                startActivity(beach);

            }
        });

        myImageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beach = new Intent(Ddashboard.this, AboutUs.class);
                startActivity(beach);

            }
        });

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Common.currentUser=null;
                Intent beach = new Intent(Ddashboard.this, MainActivity.class);
                startActivity(beach);

            }
        });

    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        Toast.makeText(Ddashboard.this,"There is no back action",Toast.LENGTH_LONG).show();
        return;
    }

    public void loadProfile() {

        profile_name = (TextView) findViewById(R.id.user_name);
        profile_mobile = (TextView) findViewById(R.id.user_id);


        profile_name.setText(Common.currentUser.getName());
        profile_mobile.setText(Common.currentUser.getMobile());

    }

}


