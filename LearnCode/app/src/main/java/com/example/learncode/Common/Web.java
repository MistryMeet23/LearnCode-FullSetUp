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

public class Web extends AppCompatActivity {

    WebView web;
    TextView take;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        web = findViewById(R.id.web);
        take = findViewById(R.id.take);

        Intent intent = getIntent();

        getSupportActionBar().hide();

        String link = intent.getExtras().getString("link");
        take.setText(link);

        ProgressDialog progressDialog = ProgressDialog.show(Web.this, "Loading", "Please Wait", true);
        progressDialog.setCancelable(false);

        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setLoadWithOverviewMode(true);
        web.getSettings().setUseWideViewPort(true);
        web.setWebViewClient(new WebViewClient() {

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

        web.loadUrl(link);

    }
}