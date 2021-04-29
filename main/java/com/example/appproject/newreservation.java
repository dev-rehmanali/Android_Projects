package com.example.appproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class newreservation extends AppCompatActivity {
    Button paysecure;
    EditText datepicker;
    EditText timepicker;
    Spinner selectRelation;
    CheckBox cottonCheckbox;
    CheckBox shroudCheckbox;
    CheckBox religionistCheckbox;
    CheckBox flowerCheckbox;
    CheckBox labourCheckbox;
    Button newReservationNameEditTextButton;
    private SharedPreferences sharedPreferences;
    private Calendar myCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newreservation);
        sharedPreferences = getSharedPreferences("loginPref",MODE_PRIVATE);

        datepicker= findViewById(R.id.newreservationDateEditText);
        timepicker = findViewById(R.id.newreservationTimeEditText);
        selectRelation = findViewById(R.id.newreservationrelationSpinner);
        cottonCheckbox = findViewById(R.id.newreservationCottonRsCheckBox);
        shroudCheckbox = findViewById(R.id.newreservationShroudRsCheckBox);
        religionistCheckbox = findViewById(R.id.newreservationReligionistRsCheckBox);
        flowerCheckbox = findViewById(R.id.newreservationFlowerRsCheckBox);
        labourCheckbox = findViewById(R.id.newreservationLabourRsCheckBox);
        newReservationNameEditTextButton = findViewById(R.id.newreservationNameEditText);
        paysecure = findViewById(R.id.newreservationPaySecureButton);
        newReservationNameEditTextButton.setText(sharedPreferences.getString("FULLNAME",null));

        myCalendar = Calendar.getInstance();

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                datepicker.setText(dayOfMonth + "/" + monthOfYear + "/" + year);


            }

        };

        datepicker.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(newreservation.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePickerView, int i, int i1) {
                myCalendar.set(Calendar.HOUR, i);
                myCalendar.set(Calendar.MINUTE, i1);
                timepicker.setText(i + ":" + i1);
            }
        };

        timepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(newreservation.this, time,
                        myCalendar.get(Calendar.HOUR), myCalendar.get(Calendar.MINUTE), true).show();
            }
        });

        selectRelation.setSelection(0);
//        ((TextView) selectRelation.getChildAt(0)).setTextColor(0x00000000);

        paysecure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(newreservation.this,jazzcashpayment.class);
                startActivity(intent);
                finish();
            }
        });


    }

}