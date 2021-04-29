package com.example.appproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class reservation extends AppCompatActivity {

    Button sliderbar;
    Button create;
    TextView textView9;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        sliderbar=findViewById(R.id.reservationslidebarButton);
        create=findViewById(R.id.reservationcreateButton);
        textView9 = findViewById(R.id.textView9);

        preferences = getSharedPreferences("loginPref",MODE_PRIVATE);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(reservation.this,newreservation.class);
                startActivity(intent);
            }
        });

//        textView9.setOnClickListener(view ->{
////            editor.clear();
////            editor.commit();
//        });

    }
}