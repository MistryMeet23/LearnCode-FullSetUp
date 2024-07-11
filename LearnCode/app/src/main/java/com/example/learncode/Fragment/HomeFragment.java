package com.example.learncode.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.learncode.Adapter.myadapter;
import com.example.learncode.Common.apicontrol;
import com.example.learncode.Model.LanModel;
import com.example.learncode.Model.SharedPrefManager;
import com.example.learncode.R;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    RecyclerView rv;
    TextView msg;
    SwipeRefreshLayout swipeRefreshLayout;
    SharedPrefManager sharedPrefManager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv = view.findViewById(R.id.rv);
        msg = view.findViewById(R.id.msg);

        sharedPrefManager = new SharedPrefManager(getActivity());

        Calendar calendar = Calendar.getInstance();
        int M = calendar.get(Calendar.HOUR_OF_DAY);

        if (M >= 0 && M < 12) {
            msg.setText("Good Morning");
        } else if (M >= 12 && M < 16) {
            msg.setText("Good Afternoon");
        } else if (M >= 16 && M < 21) {
            msg.setText("Good Evening");
        } else if (M >= 21 && M < 24) {
            msg.setText("Good Night");
        } else {
            msg.setText("Hello");
        }


        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                proceesdata();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        proceesdata();
    }

    private void proceesdata() {

        Call<List<LanModel>> call = apicontrol
                .getInstance()
                .getapi()
                .getdata();

        call.enqueue(new Callback<List<LanModel>>() {
            @Override
            public void onResponse(Call<List<LanModel>> call, Response<List<LanModel>> response) {
                List<LanModel> data = response.body();
                myadapter myadapter = new myadapter(data, getActivity());
                rv.setAdapter(myadapter);
            }

            @Override
            public void onFailure(Call<List<LanModel>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}