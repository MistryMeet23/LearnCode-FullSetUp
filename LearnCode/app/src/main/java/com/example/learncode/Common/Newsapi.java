package com.example.learncode.Common;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Newsapi {

    public static Retrofit retrofit = null;

    public static apiset getapiset() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(apiset.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(apiset.class);
    }
}
