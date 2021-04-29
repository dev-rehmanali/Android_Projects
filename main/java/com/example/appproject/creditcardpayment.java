package com.example.appproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class creditcardpayment extends AppCompatActivity {

    RadioButton creditcard;
    RadioButton jazzcash;
    EditText cardnumber;
    EditText expiredate;
    EditText cvv;
    EditText cardholdername;
    CheckBox savecard;
    Button paysecure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditcardpayment);

        creditcard=findViewById(R.id.paymentCreditCardRadioButton);
        jazzcash=findViewById(R.id.paymentJazzCashRadioButton);
        cardnumber=findViewById(R.id.paymentCardNumberEditText);
        expiredate=findViewById(R.id.paymentExpireDateEditText);
        cvv=findViewById(R.id.paymentcvvEditText);
        cardholdername=findViewById(R.id.paymentCardHolderNameEditText);
        savecard=findViewById(R.id.paymentSaveCardCheckBox);
        paysecure=findViewById(R.id.paymentPaySecureButton);

//        jazzcash.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent=new Intent(creditcardpayment.this, jazzcashpayment.class);
////                startActivity(intent);
//            }
//        });

    }
}