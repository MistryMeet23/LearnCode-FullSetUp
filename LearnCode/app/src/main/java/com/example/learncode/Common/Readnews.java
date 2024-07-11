package com.example.learncode.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.learncode.R;

public class Readnews extends AppCompatActivity {
    TextView takenews;
    WebView wv;

    @SuppressLint({"MissingInflatedId", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readnews);

        takenews = findViewById(R.id.takenews);
        wv = findViewById(R.id.wv);

        Intent intent = getIntent();

        String news = intent.getStringExtra("URL");
        takenews.setText(news);

        ProgressDialog progressDialog = ProgressDialog.show(Readnews.this, "Loading", "Please Wait", true);
        progressDialog.setCancelable(false);

        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                progressDialog.show();
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressDialog.dismiss();
            }
        });

        wv.loadUrl(news);
    }
}