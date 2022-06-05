package com.example.newandroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Api {
    @GET
    Call<Results> callAPI(@Url String url);
}