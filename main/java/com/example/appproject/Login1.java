package com.example.appproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class Login1 extends AppCompatActivity {

    // login activity
    EditText emailEditText;
    EditText passwordEditText;
    Button loginButton;
    TextView loginForgotPasswordTV;
    TextView signupTV;
    TextView donateTV;
    TextView noAccountTV;

    private DBHelper dbHelper;
    private SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        dbHelper = new DBHelper(this);
        sharedPreferences = getSharedPreferences("loginPref",MODE_PRIVATE);

        if (sharedPreferences.getBoolean("IS_LOGGED_IN",false)){
            startActivity(new Intent(this,reservation.class));
            finish();
        }

        // initialize login activity
        emailEditText = findViewById(R.id.loginEmailEditText);
        passwordEditText = findViewById(R.id.loginPasswordEditText);
        loginButton = findViewById(R.id.loginLoginButton);
        loginForgotPasswordTV = findViewById(R.id.loginForgotPasswordTextView);
        signupTV = findViewById(R.id.loginSignUpTextView);
        donateTV = findViewById(R.id.loginDonateTextView);
        noAccountTV = findViewById(R.id.logindontaccountTextView);

        signupTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login1.this, SignUp1.class);
                startActivity(intent);
                finish();
            }
        });

        loginForgotPasswordTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login1.this,resetpassword.class);
                startActivity(intent);
            }
        });

        donateTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login1.this,donation1.class);
                startActivity(intent);
            }
        });

        noAccountTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login1.this,SignUp1.class);
                startActivity(intent);
                finish();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateEmail() && validatePassword()){
                    String email = emailEditText.getText().toString();
                    String password = passwordEditText.getText().toString();

                    boolean result = dbHelper.authenticate(
                            email,password
                    );

                    if (!result){
                        Snackbar.make(view,"Username or Password is wrong",Snackbar.LENGTH_LONG).show();
                    }else{
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("EMAIL",email);
                        editor.putString("FULLNAME",dbHelper.getUser(email).getFullName());
                        editor.putString("PASSWORD",password);
                        editor.putBoolean("IS_LOGGED_IN",true);
                        editor.commit();
                        startActivity(new Intent(Login1.this,reservation.class));
                        finish();
                    }

                }//if
            }
        });


    }

    private boolean validateEmail(){
        String useremail= emailEditText.getText().toString();
        if (useremail.isEmpty()){
            emailEditText.setError("Field cannot be empty");
            return false;
        }
        else{
            emailEditText.setError(null);
            return true;
        }
    }

    private boolean validatePassword(){

        String password=passwordEditText.getText().toString();
        if (password.isEmpty()){
            passwordEditText.setError("Field cannot be empty");
            return false;
        }
        else{
            passwordEditText.setError(null);
            return true;
        }
    }

}