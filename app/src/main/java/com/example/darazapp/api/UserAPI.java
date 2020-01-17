package com.example.darazapp.api;

import com.example.darazapp.model.Users;
import com.example.darazapp.serverresponse.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserAPI {

    @POST("signup")
    Call<SignUpResponse> registerUser(@Body Users users);

    @FormUrlEncoded
    @POST("login")
    Call<SignUpResponse> checkUser(@Field("Email") String Email, @Field("Password") String Password);
}




