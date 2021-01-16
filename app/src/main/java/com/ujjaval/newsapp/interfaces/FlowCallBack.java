package com.ujjaval.newsapp.interfaces;

import com.ujjaval.newsapp.model.NewsSource;

import retrofit2.Response;

public interface FlowCallBack {

public void onSuccess(Response<NewsSource> response);
public void onFailed(Throwable t);

}
