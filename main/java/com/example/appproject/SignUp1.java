package com.example.appproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp1 extends AppCompatActivity {

    // Signup activity
    EditText usernameEditText;
    EditText fullnameEditText;
    EditText emailEditText;
    EditText contactnumEditText;
    EditText addressEditText;
    EditText passwordEditText;
    EditText confirmPasswordEditText;
    CheckBox signupcheckbox;
    Button signupButton;
    TextView signupLogin;
    TextView signupDonate;
    TextView alreadyAccount;
    Button backarrow;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);
        dbHelper = new DBHelper(this);

        usernameEditText =findViewById(R.id.signupUserNameEditText);
        fullnameEditText = findViewById(R.id.signupFullNameEditText);
        emailEditText = findViewById(R.id.signupEmailEditText);
        contactnumEditText = findViewById(R.id.signupPhoneNumberEditText);
        addressEditText = findViewById(R.id.signupAddressEditText);
        passwordEditText = findViewById(R.id.signupPasswordEditText);
        confirmPasswordEditText = findViewById(R.id.signupConfirmPasswordEditText);
        signupcheckbox = findViewById(R.id.signupcheckboxCheckBox);
        signupButton = findViewById(R.id.signupSignUpbutton);
        signupLogin = findViewById(R.id.signupLoginTextView);
        signupDonate = findViewById(R.id.signupDonateTextView);
        alreadyAccount =findViewById(R.id.signupalreadyaccountTextView);
        backarrow=findViewById(R.id.signupbackarrowButton);



        signupLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(SignUp1.this, Login1.class);
                startActivity(intent1);
            }
        });

        alreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUp1.this,Login1.class);
                startActivity(intent);
            }
        });

        signupDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUp1.this,donation1.class);
                startActivity(intent);
            }
        });

        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUp1.this,Login1.class);
                startActivity(intent);
            }
        });

        signupButton.setOnClickListener(view->{

            if (validateUsername() && validateFullname() && validateEmail() && validateMobileNo()
                    && validateAddress() && validatePassword() && validateConfirmPassword() && validateTerms()){

                dbHelper.insertUser(new User(usernameEditText.getText().toString(),fullnameEditText.getText().toString(),
                        emailEditText.getText().toString(),contactnumEditText.getText().toString(),addressEditText.getText().toString(),
                        passwordEditText.getText().toString()));
                startActivity(new Intent(SignUp1.this,Login1.class));
                finish();

            }else {

            }

        });

    }
    private boolean validateUsername(){
        String username=usernameEditText.getText().toString();
        if (username.isEmpty()){
            usernameEditText.setError("Field cannot be empty");
            return false;
        }
        else if (username.length()>15){
            usernameEditText.setError("Please Enter from 0 to 15 chars");
            return false;
        }
        else if (username.contains(" ")){
            usernameEditText.setError("White Spaces are not allowed");
            return false;
        }
        else{
            usernameEditText.setError(null);
            return true;
        }
    }

    private boolean validateFullname(){
        String fullname=fullnameEditText.getText().toString();
        String pattern="^[a-zA-Z]{8,}(?: [a-zA-Z]+)?(?: [a-zA-Z]+)?$";
        String noWhiteSpace="(?=\\S+$)";
        if (fullname.isEmpty()){
            fullnameEditText.setError("Field cannot be empty");
            return false;
        }
        else if (fullname.contains(" ")){
            fullnameEditText.setError("Whtie Spaces are not allowed");
            return false;
        }
        else{
            fullnameEditText.setError(null);
            return true;
        }

    }

    private boolean validateEmail(){
        String useremail= emailEditText.getText().toString();
        if (useremail.isEmpty()){
            emailEditText.setError("Field cannot be empty");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(useremail).matches()){
            emailEditText.setError("Invalid Email");
            return false;
        }
        else{
            emailEditText.setError(null);
            return true;
        }
    }

    private boolean validateMobileNo(){
        String mobileno = contactnumEditText.getText().toString();
        String regexStr = "^[0-9]$";
        if (mobileno.isEmpty()){
            contactnumEditText.setError("Field cannot be empty");
            return false;
        }
//        else if (!mobileno.matches(regexStr) || (mobileno.length()<13)){
        else if ((mobileno.length()<13)){
            contactnumEditText.setError("Invalid Contact Number");
            return false;
        }
        else{
            contactnumEditText.setError(null);
            return true;
        }
    }

    private boolean validateAddress(){
        String address= addressEditText.getText().toString();
        String pattern="^[a-zA-Z]{8,}(?: [a-zA-Z]+)?(?: [a-zA-Z]+)?$";
        String noWhiteSpace="(?=\\S+$)";
        if (address.isEmpty()){
            addressEditText.setError("Field cannot be empty");
            return false;
        }
//        else if (!address.matches(pattern)){
//            addressEditText.setError("Write complete the address");
//            return false;
//        }
//        else if (address.contains(" ")){
//            addressEditText.setError("White spaces are not allowed");
//            return false;
//        }
        else{
            addressEditText.setError(null);
            return true;
        }
    }

    private boolean validatePassword(){
        String password=passwordEditText.getText().toString();
//        String pattern ="^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        if (password.isEmpty()){
            passwordEditText.setError("Field cannot be empty");
            return false;
        }
//        else if (password.length()<8 ||(!password.matches(pattern))){
        else if (password.length()<8){
            passwordEditText.setError("Please enter atleast 8 chars");
            return false;
        }
        else if (password.contains(" ")){
            passwordEditText.setError("Please enter atleast 1 UPPERCASE");
            return false;
        }
        else{
            passwordEditText.setError(null);
            return true;
        }
    }

    private boolean validateConfirmPassword(){
        String password = passwordEditText.getText().toString();
        String confirmpassword = confirmPasswordEditText.getText().toString();
        String noWhiteSpace="(?=\\S+$)";
        if (confirmpassword.isEmpty()){
            confirmPasswordEditText.setError("Field connot be empty");
            return false;
        }
        else if (!confirmpassword.equals(password) && validatePassword()){
            confirmPasswordEditText.setError("Passwords does not match");
            return false;
        }
        else{
            confirmPasswordEditText.setError(null);
            return true;
        }

    }

    public boolean validateTerms(){

        if (!signupcheckbox.isChecked()){
            signupcheckbox.setError("Please Accept Terms");
            return false;
        }
        else{
            signupcheckbox.setError(null);
            return true;
        }

    }

}