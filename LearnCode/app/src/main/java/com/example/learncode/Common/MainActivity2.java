package com.example.learncode.Common;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learncode.Adapter.myadapter2;
import com.example.learncode.Model.LanModel2;
import com.example.learncode.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    TextView id;
    RecyclerView rvdata;
    SwipeRefreshLayout swipeRefreshLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        id = findViewById(R.id.id);
        rvdata = findViewById(R.id.rvdata);

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        Intent intent = getIntent();

        String name = intent.getExtras().getString("name");
        String aid = intent.getExtras().getString("id");

        id.setText(aid);

        getSupportActionBar().setTitle(name);
        proceesdata(aid);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                proceesdata(aid);
                swipeRefreshLayout.setRefreshing(false);

            }
        });
        LinearLayoutManager lm = new LinearLayoutManager(MainActivity2.this, LinearLayoutManager.VERTICAL, false);
        rvdata.setLayoutManager(lm);
        rvdata.setItemAnimator(new DefaultItemAnimator());

    }

    private void proceesdata(String aid) {

        Call<List<LanModel2>> call = apicontrol
                .getInstance()
                .getapi()
                .getlink(Integer.parseInt(aid));

        call.enqueue(new Callback<List<LanModel2>>() {
            @Override
            public void onResponse(@NonNull Call<List<LanModel2>> call, @NonNull Response<List<LanModel2>> response) {
                List<LanModel2> link = response.body();
                myadapter2 myadapter2 = new myadapter2(link, getApplicationContext());
                rvdata.setAdapter(myadapter2);
            }

            @Override
            public void onFailure(@NonNull Call<List<LanModel2>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}