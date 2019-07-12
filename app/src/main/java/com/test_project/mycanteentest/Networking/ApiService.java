package com.test_project.mycanteentest.Networking;

import com.test_project.mycanteentest.Model.Kantin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("kantin.json")
    Call<Kantin> getContent();

    //@FormUrlEncoded
   // @POST("login.php")
    //Call<Kantin> login(@Field("username") String uname,
                      // @Field("password") String pass);

}
