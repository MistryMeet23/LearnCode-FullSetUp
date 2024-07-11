package com.example.learncode.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.learncode.Common.apicontrol;
import com.example.learncode.LoginRegister.UpdateUser;
import com.example.learncode.LoginRegister.Login;
import com.example.learncode.Model.DeleteModel;
import com.example.learncode.Model.SharedPrefManager;
import com.example.learncode.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {

    TextView tvuser, useremail, tvset1;
    RelativeLayout p2, update, delete;
    ImageView userimg;
    SharedPrefManager sharedPrefManager;

    private static int RC_SIGN_IN = 1000;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, null);

        tvuser = view.findViewById(R.id.tvuser);
        useremail = view.findViewById(R.id.useremail);

        p2 = view.findViewById(R.id.p2);
        update = view.findViewById(R.id.update);
        tvset1 = view.findViewById(R.id.tvset1);
        userimg = view.findViewById(R.id.userimg);
        delete = view.findViewById(R.id.delete);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), UpdateUser.class);
                startActivity(intent);

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deleteuser();

            }
        });

        sharedPrefManager = new SharedPrefManager(getActivity());

        tvuser.setText(sharedPrefManager.getuser().getName());
        useremail.setText(sharedPrefManager.getuser().getEmail());

        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPrefManager.logout();
                Intent intent = new Intent(getActivity(), Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                Toast.makeText(getActivity(), "You Have Been Logout", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

    private void deleteuser() {

        Call<DeleteModel> call = apicontrol.getInstance().getapi().deleteuser(sharedPrefManager.getuser().getId());
        call.enqueue(new Callback<DeleteModel>() {
            @Override
            public void onResponse(Call<DeleteModel> call, Response<DeleteModel> response) {

                DeleteModel dm = response.body();

                if (response.isSuccessful()) {

                    if (dm.getError().equals("200")) {
                        sharedPrefManager.logout();
                        Intent intent = new Intent(getActivity(), Login.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);

                        Toast.makeText(getActivity(), "You Have Been Logout", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getContext(), dm.getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), dm.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<DeleteModel> call, Throwable t) {

                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}