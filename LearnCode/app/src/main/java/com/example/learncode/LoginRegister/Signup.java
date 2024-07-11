package com.example.learncode.LoginRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learncode.Common.apicontrol;
import com.example.learncode.Model.RegisterModel;
import com.example.learncode.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signup extends AppCompatActivity {

    TextView register, alredyaccount;
    EditText name, email, number;
    Button registerbtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getSupportActionBar().hide();

        register = findViewById(R.id.register);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        number = findViewById(R.id.number);

        registerbtn = findViewById(R.id.registerbtn);
        alredyaccount = findViewById(R.id.alredyaccount);

        alredyaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);
                finish();

            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String uname = name.getText().toString();
                String uemail = email.getText().toString();
                String unumber = number.getText().toString();

                if (uname.isEmpty()) {
                    name.requestFocus();
                    name.setError("Please Enter your Name");
                    return;
                }
                if (uemail.isEmpty()) {
                    email.requestFocus();
                    email.setError("Please Enter your Email");
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(uemail).matches()) {
                    email.requestFocus();
                    email.setError("Please Enter Correct Email");
                    return;
                }
                if (unumber.isEmpty()) {
                    number.requestFocus();
                    number.setError("Please Enter your Number");
                    return;
                }
                if (unumber.length() < 10) {
                    number.requestFocus();
                    number.setError("Please Enter 10 Digit Number");
                    return;
                }


                Call<RegisterModel> Call = apicontrol
                        .getInstance()
                        .getapi()
                        .registerapi(uname, uemail, unumber);

                Call.enqueue(new Callback<RegisterModel>() {
                    @Override
                    public void onResponse(retrofit2.Call<RegisterModel> call, Response<RegisterModel> response) {

                        RegisterModel rm = response.body();
                        if (response.isSuccessful()) {
                            Toast.makeText(Signup.this, rm.getMessage(), Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(Signup.this, Login.class);
                            startActivity(intent);
                            finish();

                        } else {

                            Toast.makeText(Signup.this, rm.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(retrofit2.Call<RegisterModel> call, Throwable t) {
                        Toast.makeText(Signup.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}