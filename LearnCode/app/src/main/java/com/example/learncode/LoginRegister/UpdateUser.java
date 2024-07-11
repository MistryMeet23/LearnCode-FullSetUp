package com.example.learncode.LoginRegister;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learncode.Common.apicontrol;
import com.example.learncode.Fragment.ProfileFragment;
import com.example.learncode.Model.LoginModel;
import com.example.learncode.Model.SharedPrefManager;
import com.example.learncode.Model.UpdateModel;
import com.example.learncode.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateUser extends AppCompatActivity implements View.OnClickListener {

    EditText upname, upemail;
    Button upbtn;
    SharedPrefManager sharedPrefManager;
    int userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        getSupportActionBar().hide();

        upname = findViewById(R.id.upname);
        upemail = findViewById(R.id.upemail);
        upbtn = findViewById(R.id.upbtn);

        sharedPrefManager = new SharedPrefManager(getApplicationContext());

        userid = sharedPrefManager.getuser().getId();

        Log.e("Userid", String.valueOf(userid));
        upbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        upuser();

    }

    private void upuser() {

        String username = upname.getText().toString().trim();
        String useremail = upemail.getText().toString().trim();

        if (username.isEmpty()) {
            upname.setError("Please Enter User Name");
            upname.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(useremail).matches()) {
            upemail.requestFocus();
            upemail.setError("Please Enter Correct Email");
            return;
        }

        Call<UpdateModel> call = apicontrol
                .getInstance()
                .getapi()
                .updatauserdata(userid, username, useremail);

        call.enqueue(new Callback<UpdateModel>() {
            @Override
            public void onResponse(Call<UpdateModel> call, Response<UpdateModel> response) {

                UpdateModel lM = response.body();
                if (response.isSuccessful()) {
                    if (lM.getError().equals("200")) {

                        sharedPrefManager.saveuser(lM.getUser());
                        Toast.makeText(UpdateUser.this, lM.getMessage(), Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(UpdateUser.this, lM.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                } else {

                    Toast.makeText(UpdateUser.this, "Failed", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<UpdateModel> call, Throwable t) {

                Toast.makeText(UpdateUser.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}