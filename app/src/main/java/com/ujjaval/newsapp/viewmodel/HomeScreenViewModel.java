package com.ujjaval.newsapp.viewmodel;

import android.content.Context;

import com.ujjaval.newsapp.R;
import com.ujjaval.newsapp.adapter.Adapter;
import com.ujjaval.newsapp.interfaces.ApiInterface;
import com.ujjaval.newsapp.interfaces.FlowCallBack;
import com.ujjaval.newsapp.model.NewsSource;
import com.ujjaval.newsapp.util.ApiClient;
import com.ujjaval.newsapp.util.ApplicationConstants;
import com.ujjaval.newsapp.view.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeScreenViewModel {

    FlowCallBack flowCallBack;
    Context context;

    public HomeScreenViewModel(MainActivity mainActivity){
        context=mainActivity;
    }

    public void firapi(){

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        String country = "in";

        Call<NewsSource> call;


        call = apiInterface.getNews(country, ApplicationConstants.API_KEY);


        call.enqueue(new Callback<NewsSource>() {
            @Override
            public void onResponse(Call<NewsSource> call, Response<NewsSource> response) {
                flowCallBack=  (FlowCallBack) context;

                flowCallBack.onSuccess(response);
            }

            @Override
            public void onFailure(Call<NewsSource> call, Throwable t) {
                flowCallBack=  (FlowCallBack) context;
                flowCallBack.onFailed(t);
            }
        });

    }
}
