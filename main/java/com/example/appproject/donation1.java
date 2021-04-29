package com.example.appproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class donation1 extends AppCompatActivity {

    // donation activity
    EditText fullname;
    EditText amount;
    Button next;
    Button backarrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation1);

        fullname=findViewById(R.id.donationFullNameEditText);
        amount=findViewById(R.id.donationAmountEditText);
        next=findViewById(R.id.donationNextButton);
        backarrow=findViewById(R.id.donationbackarrowButton);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(donation1.this,jazzcashpayment.class);
                startActivity(intent);
            }
        });
        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(donation1.this,Login1.class);
                startActivity(intent);
            }
        });
    }
}