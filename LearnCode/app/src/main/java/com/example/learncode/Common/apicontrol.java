package com.example.learncode.Common;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apicontrol {

    private static final String url = "http://192.168.66.181/learncodedb/";
    private static apicontrol clientobject;
    private static Retrofit retrofit;

    apicontrol() {

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized apicontrol getInstance() {
        if (clientobject == null)
            clientobject = new apicontrol();
        return clientobject;
    }

    public apiset getapi() {
        return retrofit.create(apiset.class);
    }
}
