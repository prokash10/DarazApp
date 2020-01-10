package com.example.darazapp.api;

import com.example.darazapp.model.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductAPI {
    @GET("product/list")
    Call<List<Products>> getProduct();

}
