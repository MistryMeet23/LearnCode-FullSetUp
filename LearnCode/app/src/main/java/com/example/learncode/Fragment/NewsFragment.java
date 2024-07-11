package com.example.learncode.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.learncode.Adapter.Newsadapter;
import com.example.learncode.Common.Mainnews;
import com.example.learncode.Common.Newsapi;
import com.example.learncode.Common.apicontrol;
import com.example.learncode.Model.LanModel;
import com.example.learncode.Model.NewsModel;
import com.example.learncode.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends Fragment {

    String API_Key = "cd34f70076064edd9b88f8b846478027";
    RecyclerView rvn;
    Newsadapter newsadapter;
    SwipeRefreshLayout swipeRefreshLayout;
    ArrayList<NewsModel> newsModelArrayList;

    //https://newsapi.org/v2/top-headlines?country=in&category=technology&apikey=cd34f70076064edd9b88f8b846478027

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news, null);

        rvn = view.findViewById(R.id.rvn);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);

        newsModelArrayList = new ArrayList<>();
        newsadapter = new Newsadapter(getContext(), newsModelArrayList);
        rvn.setAdapter(newsadapter);
        rvn.setLayoutManager(new LinearLayoutManager(getContext()));

        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getnews();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        getnews();
        return view;
    }

    void getnews() {
        Newsapi.getapiset().getcategory("in", "technology", 100, API_Key).enqueue(new Callback<Mainnews>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<Mainnews> call, Response<Mainnews> response) {
                if (response.isSuccessful()) {
                    newsModelArrayList.addAll(response.body().getArticles());
                    newsadapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Mainnews> call, Throwable t) {

                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}