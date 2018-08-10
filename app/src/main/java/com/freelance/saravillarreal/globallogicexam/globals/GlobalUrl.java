package com.freelance.saravillarreal.globallogicexam.globals;

import com.freelance.saravillarreal.globallogicexam.services.ApiService;
import com.freelance.saravillarreal.globallogicexam.services.RetrofitClient;

public class GlobalUrl {

    private GlobalUrl() {}


    /***** Developer *******/

    public static final String BASE_URL = "http://private-f0eea-mobilegllatam.apiary-mock.com";



    public static ApiService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
