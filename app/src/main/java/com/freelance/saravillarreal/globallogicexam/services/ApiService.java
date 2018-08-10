package com.freelance.saravillarreal.globallogicexam.services;

import com.freelance.saravillarreal.globallogicexam.beans.MockGlobal;
import com.freelance.saravillarreal.globallogicexam.globals.GlobalUrl;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static ApiService apiInstance;
    private Api mApi;

    /**
     * Private constructor
     */
    private ApiService() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        String baseUrl;

        baseUrl = GlobalUrl.BASE_URL;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mApi = retrofit.create(Api.class);
    }

    public static ApiService newInstance() {

        ApiService fragment = new ApiService();
        return fragment;
    }


    /**
     * Singlenton Pattern
     *
     * @return ApiService {@link ApiService}
     */
    public static final synchronized ApiService getInstance() {
        if (apiInstance == null) {
            apiInstance = new ApiService();
        }
        return apiInstance;
    }

    /**
     * Getting list Globallogic
     *
     */
    public Call<ArrayList<MockGlobal>> getList() {
        return mApi.getList();
    }
}
