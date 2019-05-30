package com.example.lenovo.demo1;

import api.ApiService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataService {
    public static ApiService apiService;
    private static ApiService service;

    public static ApiService getApiService(){
        if (apiService == null){
            synchronized (DataService.class){
                if (apiService == null){
                    //拦截器
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    if (BuildConfig.DEBUG){
                        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    }else {
                        interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
                    }
                    OkHttpClient okHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(interceptor)
                            .build();
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(ApiService.url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(okHttpClient)
                            .build();
                    service = retrofit.create(ApiService.class);
                }
            }
        }
        return service;
    }
}
