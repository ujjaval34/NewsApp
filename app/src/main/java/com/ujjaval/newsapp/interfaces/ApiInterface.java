package com.ujjaval.newsapp.interfaces;

import com.ujjaval.newsapp.model.NewsSource;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines")
    Call<NewsSource> getNews(

            @Query("country") String country,
            @Query("apiKey") String apiKey

    );



}
