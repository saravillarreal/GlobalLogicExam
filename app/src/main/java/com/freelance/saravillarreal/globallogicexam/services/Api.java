package com.freelance.saravillarreal.globallogicexam.services;

import com.freelance.saravillarreal.globallogicexam.beans.MockGlobal;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {



    @GET("/list")
    Call<ArrayList<MockGlobal>> getList();

}
