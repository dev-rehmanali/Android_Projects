package com.example.appproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class setnewpassword extends AppCompatActivity {
    EditText passwrod;
    EditText confirmpassword;
    Button save;
    Button backarrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setnewpassword);

        passwrod=findViewById(R.id.setnewpasswordPasswordEditText);
        confirmpassword=findViewById(R.id.setnewpasswordConfirmPasswordEditText);
        save=findViewById(R.id.setnewpasswordSaveButton);
        backarrow=findViewById(R.id.setnewpasswordbackarrowButton);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(setnewpassword.this, Login1.class);
                startActivity(intent);
            }
        });

        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(setnewpassword.this,otpverification.class);
                startActivity(intent);

            }
        });
    }
}