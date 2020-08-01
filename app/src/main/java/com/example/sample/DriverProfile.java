package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.sample.Common.Common;
import com.example.sample.Model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DriverProfile extends AppCompatActivity {


    public TextView profile_name,  profile_email, profile_vehicle,profile_license;
    FirebaseStorage storage;
    StorageReference storageReference;
    User newUser;
    FirebaseDatabase db;
    DatabaseReference user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driverprofile);
        db = FirebaseDatabase.getInstance();

        user = db.getReference("Driver").child(Common.currentUser.getMobile());
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        loadProfile();


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("Driver");

    }
    public void loadProfile() {

        profile_name = (TextView) findViewById(R.id.editTextTextPersonName6);
        profile_email = (TextView) findViewById(R.id.editTextTextPersonName7);
        profile_vehicle = (TextView)findViewById(R.id.editTextTextPersonName9);
        profile_license = (TextView)findViewById(R.id.editTextTextPersonName8);

        profile_name.setText(Common.currentUser.getName());
        profile_vehicle.setText(Common.currentUser.getVehicle());
        profile_email.setText(Common.currentUser.getEmail());
        profile_license.setText(Common.currentUser.getLicense());

    }
}



