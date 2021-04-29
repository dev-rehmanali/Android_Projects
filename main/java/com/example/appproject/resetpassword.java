package com.example.appproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class resetpassword extends AppCompatActivity {

    // resetpassword activity
    EditText email;
    Button resetpassword;
    Button backarrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);

        // initialize activity
        email=findViewById(R.id.resetpasswordEmailAddressEditText);
        resetpassword=findViewById(R.id.resetpasswordResetPasswordButton);
        backarrow=findViewById(R.id.resetpasswordbackarrowButton);

        resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(resetpassword.this,otpverification.class);
                startActivity(intent);
            }
        });

        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(resetpassword.this,Login1.class);
                startActivity(intent);
            }
        });
    }
}