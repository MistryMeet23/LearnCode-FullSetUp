package com.example.learncode.LoginRegister;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learncode.Common.MainActivity;
import com.example.learncode.Common.apicontrol;
import com.example.learncode.Fragment.ProfileFragment;
import com.example.learncode.Model.LoginModel;
import com.example.learncode.Model.SharedPrefManager;
import com.example.learncode.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    TextView login, signup, fpass;
    EditText lemail;
    Button submit;
    SharedPrefManager sharedPrefManager;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        lemail = findViewById(R.id.lemail);
        signup = findViewById(R.id.signup);

        submit = findViewById(R.id.submit);


        sharedPrefManager = new SharedPrefManager(getApplicationContext());

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Login.this, Signup.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String loginemail = lemail.getText().toString();

                if (loginemail.isEmpty()) {
                    lemail.requestFocus();
                    lemail.setError("Please Enter your Email");
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(loginemail).matches()) {
                    lemail.requestFocus();
                    lemail.setError("Please Enter Correct Email");
                    return;
                }

                Call<LoginModel> call = apicontrol
                        .getInstance()
                        .getapi()
                        .login(loginemail);

                call.enqueue(new Callback<LoginModel>() {
                    @Override
                    public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                        LoginModel lm = response.body();

                        if (response.isSuccessful()) {
                            if (lm.getError().equals("200")) {

                                sharedPrefManager.saveuser(lm.getUser());

                                Intent intent = new Intent(Login.this, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);

                                Toast.makeText(Login.this, lm.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginModel> call, Throwable t) {
                        Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (sharedPrefManager.isloggedin()) {
            Intent intent = new Intent(Login.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}