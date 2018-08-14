package com.freelance.saravillarreal.globallogicexam.interactors;

import android.util.Log;

import com.freelance.saravillarreal.globallogicexam.beans.MockGlobal;
import com.freelance.saravillarreal.globallogicexam.interfaces.MainInteractorInterface;
import com.freelance.saravillarreal.globallogicexam.interfaces.MainOnListener;
import com.freelance.saravillarreal.globallogicexam.services.ApiService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MainInteractorImpl  implements MainInteractorInterface {

    public static ApiService apiService;

    @Override
    public void callListService(final MainOnListener listener) {

        // callService
        Log.i("callListService", "callListService");
        //get unique Instance of ApiService
        apiService = apiService.newInstance();


        Call<ArrayList<MockGlobal>> catalogueService =  apiService.getList();
        catalogueService.enqueue(new retrofit2.Callback<ArrayList<MockGlobal>>() {

            @Override
            public void onResponse(Call<ArrayList<MockGlobal>> call, Response<ArrayList<MockGlobal>> response) {
                switch (response.code()) {
                    case 200:
                        try{
                            Gson gson = new Gson();
                            //Convert response.body().getMatchs() to JsonArray because coming in LinkedTreeMap
                            JsonArray jsonArray = gson.toJsonTree(response.body()).getAsJsonArray();
                            Type type = new TypeToken<List<MockGlobal>>() {}.getType();
                            //Transform the JsonArray to List <Match>
                            List<MockGlobal> matchList = gson.fromJson(jsonArray, type);
                            listener.resultList(matchList);

                        }
                        catch (Exception e){
                            String exs = e.toString();
                            String stuatus = "NONE";
                        }

                        break;
                    case 401:

                        break;
                    default:

                        break;
                }
            }

            @Override
            public void onFailure(Call<ArrayList<MockGlobal>> call, Throwable t) {
                Log.i("onFailure", "loadList");
                listener.resultListError();
            }
        });
    }
}
