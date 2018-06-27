package com.dhirajnayak.axsimageapp.network;

import com.dhirajnayak.axsimageapp.utility.ApplicationConstant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Name: HTTPRequest
 * Purpose: provide request class to make HTTP calls
 */
public class HTTPRequest {
    private static Retrofit mRetrofit = null;

    /**
     * private constructor to limit to single instance
     */
    private HTTPRequest() {}

    /**
     * create retrofit object using base url
     * @return retrofit object
     */
    public static synchronized Retrofit getRetrofitInstance(){
        if (mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(ApplicationConstant.URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

    /**
     *
     * @param serviceClass
     * @param <S> - service
     * @return - service
     */
    public static <S> S createService(Class<S> serviceClass){
        getRetrofitInstance();
        return mRetrofit.create(serviceClass);
    }
}
