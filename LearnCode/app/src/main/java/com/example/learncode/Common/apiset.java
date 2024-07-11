package com.example.learncode.Common;

import com.example.learncode.Model.DeleteModel;
import com.example.learncode.Model.LanModel;
import com.example.learncode.Model.LanModel2;
import com.example.learncode.Model.LoginModel;
import com.example.learncode.Model.RegisterModel;
import com.example.learncode.Model.UpdateModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface apiset {

    @GET("languageapi.php")
    Call<List<LanModel>> getdata();

    @GET("homeapi.php")
    Call<List<LanModel2>> getlink(@Query("lid") int lid);

    @FormUrlEncoded
    @POST("registerapi.php")
    Call<RegisterModel> registerapi(
            @Field("name") String name,
            @Field("email") String email,
            @Field("number") String number
    );

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginModel> login(
            @Field("email") String email
    );

    @FormUrlEncoded
    @POST("updateuser.php")
    Call<UpdateModel> updatauserdata(
            @Field("id") int id,
            @Field("name") String username,
            @Field("email") String email
    );

    /*@POST("updateuser.php")
    Call<UpdateModel> updatauserdata(
            @Field("id") int id,
            @Field("name") String username,
            @Field("email") String email
    );*/


    @FormUrlEncoded
    @POST("deleteuserapi.php")
    Call<DeleteModel> deleteuser(
            @Field("id") int userid
    );


    String BASE_URL = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<Mainnews> getnews(
            @Query("country") String country,
            @Query("pageSize") int pagesize,
            @Query("apikey") String apikey
    );

    @GET("top-headlines")
    Call<Mainnews> getcategory(
            @Query("country") String country,
            @Query("category") String category,
            @Query("pageSize") int pagesize,
            @Query("apikey") String apikey
    );
}
