package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.Dialog;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.view.View.OnClickListener;

import java.util.Calendar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import com.example.sample.Common.Common;

public class Loaddetail extends AppCompatActivity {

    private EditText date,time,quantity,type;
    private Button upload;
    private static Button btndate, btntime;
    private static final int Date_id = 0;
    private static final int Time_id = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loaddetail);


        date = findViewById(R.id.editTextDate2);
        time = findViewById(R.id.editTextDate);
        quantity = findViewById(R.id.editTextNumber2);
        type = findViewById(R.id.loadtype);
        upload = findViewById(R.id.button);

        btndate = (Button) findViewById(R.id.btn_date);
        btntime = (Button) findViewById(R.id.btn_time);

        btndate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Show Date dialog
                showDialog(Date_id);
            }
        });
        btntime.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Show time dialog
                showDialog(Time_id);
            }
        });



        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Common.currentUser.setDate(date.getText().toString());
                Common.currentUser.setTime(time.getText().toString());
                Common.currentUser.setQuantity(quantity.getText().toString());
                Common.currentUser.setType(type.getText().toString());

                FirebaseDatabase.getInstance().getReference("User").child(Common.currentUser.getMobile()).setValue(Common.currentUser)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                Intent farmerlogin = new Intent(Loaddetail.this, DriverList.class);
                                startActivity(farmerlogin);
                             //   Toast.makeText(Loaddetail.this, "Update Successfully!", Toast.LENGTH_SHORT).show();
                                finish();
                            }

                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Loaddetail.this, "Cannot Update!", Toast.LENGTH_SHORT).show();
                            }
                        });

            }



        });

    }

    protected Dialog onCreateDialog(int id) {

        // Get the calander
        Calendar c = Calendar.getInstance();

        // From calander get the year, month, day, hour, minute
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        switch (id) {
            case Date_id:

                // Open the datepicker dialog
                return new DatePickerDialog(Loaddetail.this, date_listener, year,
                        month, day);
            case Time_id:

                // Open the timepicker dialog
                return new TimePickerDialog(Loaddetail.this, time_listener, hour,
                        minute, false);

        }
        return null;
    }

    // Date picker dialog
    DatePickerDialog.OnDateSetListener date_listener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            // store the data in one string and set it to text
            String date1 = String.valueOf(month) + "/" + String.valueOf(day)
                    + "/" + String.valueOf(year);
            date.setText(date1);
        }
    };
    TimePickerDialog.OnTimeSetListener time_listener = new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hour, int minute) {
            // store the data in one string and set it to text
            String time1 = String.valueOf(hour) + ":" + String.valueOf(minute);
            time.setText(time1);
        }
    };


}



