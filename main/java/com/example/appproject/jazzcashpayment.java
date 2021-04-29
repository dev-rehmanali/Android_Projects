package com.example.appproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class jazzcashpayment extends AppCompatActivity {
    RadioButton creditcard;
    RadioButton jazzcash;
    EditText mobileno;
    EditText mpin;
    Button proceed;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jazzcashpayment);

        creditcard=findViewById(R.id.jazzcashPaymentCreditCardRadioButton);
        jazzcash=findViewById(R.id.jazzcashpaymentJazzCashRadioButton);
        mobileno=findViewById(R.id.jazzcashpaymentMobileNumberEditText);
        mpin=findViewById(R.id.jazzcashpaymentMPINEditText);
        proceed=findViewById(R.id.jazzcashpaymentProceedButton);
        cancel=findViewById(R.id.jazzcashpaymentCancelButton);

        proceed.setOnClickListener(view  ->{
            if (validateNumberAndMpin()){
                Intent intent=new Intent(jazzcashpayment.this,reservation.class);
                startActivity(intent);
                finish();
            }

        });

    }

    private boolean validateNumberAndMpin(){

        boolean result = false;

        if(mobileno.getText().toString().isEmpty()){
            mobileno.setError("Field cannot be empty");
        }else if(mpin.getText().toString().isEmpty()){
            mpin.setError("Field cannot be empty");
        }else if(mpin.getText().toString().length()>4) {
            mpin.setError("Enter only four digit pin");
        }else {
            mobileno.setError(null);
            mpin.setError(null);
            result = true;
        }
        return result;
    }//validateNumberAndMpin

}