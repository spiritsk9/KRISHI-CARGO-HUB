package com.example.sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sample.Common.Common;
import com.example.sample.Modules.RecyclerViewClickListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;


public class AcceptedLoad extends AppCompatActivity {
    private List<Driver> listData;
    private RecyclerView rv;
    private AcceptedLoadAdapter adapter;
    private TextView source;
    String priceKg;
    String priceKm;
    Button sendrquest;
    private static final int REQUEST_PHONE_CALL = 1;
    RecyclerViewClickListener listener = new RecyclerViewClickListener() {
        @Override
        public void onClick(int position) {
            String qty = Common.currentUser.getQuantity();
            String distance = Common.currentUser.getDistance();
            distance = distance.substring(0, distance.length() - 3);

            double totalPriecPerkg = (Double.parseDouble(qty) * Double.parseDouble(priceKg));
            double totalPriecPerkm = (Double.parseDouble(distance) * Double.parseDouble(priceKm));
            double totalAmount = totalPriecPerkg + totalPriecPerkm;

            Common.currentUser.setTotalPrice(String.valueOf(totalAmount));
            FirebaseDatabase.getInstance().getReference("User").child(Common.currentUser.getMobile()).setValue(Common.currentUser)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            startActivity(new Intent(AcceptedLoad.this, ViewBillActivity.class));
                            finish();
                        }

                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                        }
                    });

        }

        @Override
        public void onCall(int position) {
            String mobile = listData.get(position).getMobile();
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + mobile));// Initiates the Intent
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accepted_load);

        rv = (RecyclerView) findViewById(R.id.recyclerview);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        listData = new ArrayList<>();


        final DatabaseReference nm = FirebaseDatabase.getInstance().getReference("Accepted Load");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot npsnapshot : dataSnapshot.getChildren()) {
                        Driver l = npsnapshot.getValue(Driver.class);
                        listData.add(l);
                    }
                    adapter = new AcceptedLoadAdapter(listData, listener);
                    rv.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        final DatabaseReference price = FirebaseDatabase.getInstance().getReference("Price");
        price.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                priceKg = String.valueOf(dataSnapshot.child("pricekg").getValue());
                priceKm = String.valueOf(dataSnapshot.child("pricekm").getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
//        final DatabaseReference farmerprofile = FirebaseDatabase.getInstance().getReference("User").child(Common.currentUser.getMobile());;
//        farmerprofile.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                priceKg= String.valueOf(dataSnapshot.child("pricekg").getValue());
//                priceKm= String.valueOf(dataSnapshot.child("pricekm").getValue());
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });


    }

}

