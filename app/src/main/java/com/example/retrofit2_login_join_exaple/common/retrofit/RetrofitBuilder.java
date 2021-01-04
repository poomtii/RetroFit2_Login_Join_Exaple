package com.example.retrofit2_login_join_exaple.common.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    private static RetrofitBuilder instance = null;
    private static RetrofitService service;

    public RetrofitBuilder(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(RetrofitService.class);
    }

    public static RetrofitBuilder getInstance(String url) {
        if(instance == null) {
            instance = new RetrofitBuilder(url);
        }
        return instance;
    }

    public static RetrofitService getService() {
        return service;
    }

}