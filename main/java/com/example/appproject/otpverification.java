package com.example.appproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class otpverification extends AppCompatActivity {
    EditText otp;
    //TextView invalidemail;
    Button verify;
    TextView resend;
    Button backarrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);

        otp=findViewById(R.id.otpverificationOTPEditText);
        //invalidemail=findViewById(R.id.otpverificationinvalidemailTextView);
        verify=findViewById(R.id.otpverificationVerifyButton);
        resend=findViewById(R.id.otpverificationResendTextView);
        backarrow=findViewById(R.id.otpverificationbackarrowButton);

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(otpverification.this,setnewpassword.class);
                startActivity(intent);
            }
        });

//        invalidemail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(otpverification.this,resetpassword.class);
//                startActivity(intent);
//            }
//        });

        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(otpverification.this,resetpassword.class);
                startActivity(intent);
            }
        });


    }
}