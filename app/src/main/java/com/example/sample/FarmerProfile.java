package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sample.Common.Common;
import com.example.sample.Model.User;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import android.os.Bundle;

public class FarmerProfile extends AppCompatActivity {

    public TextView profile_name,  profile_email, profile_address;
    FirebaseStorage storage;
    StorageReference storageReference;
    User newUser;
    FirebaseDatabase db;
    DatabaseReference user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmerprofile);

        db = FirebaseDatabase.getInstance();

        user = db.getReference("User").child(Common.currentUser.getMobile());
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        loadProfile();


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

    }
        public void loadProfile() {

            profile_name = (TextView) findViewById(R.id.editTextTextPersonName2);
            profile_email = (TextView) findViewById(R.id.editTextTextPersonName4);
            profile_address = (TextView)findViewById(R.id.editTextTextPersonName5);

            profile_name.setText(Common.currentUser.getName());
            profile_address.setText(Common.currentUser.getAddress());
            profile_email.setText(Common.currentUser.getEmail());

        }
        }



