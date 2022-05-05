package com.example.movieappmvvm;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    public MutableLiveData<MovieModel> getMoviesList(){
        MutableLiveData<MovieModel> mutableLiveData = new MutableLiveData<>();
        ApiInterface apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        Map<String, Object> prams = new HashMap<>();
        prams.put("api_key", "3a7c97a5a189239f438797aca4f3afad");
        apiInterface.getMovies(prams).enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                if (response.isSuccessful() && response.body()!=null){
                    mutableLiveData.setValue(response.body());

                }else{
                    Log.d(TAG, "onResponse: Error in response..."+response.code());
                }
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                Log.d(TAG, "onFailure: "+call.toString());
            }
        });

        return mutableLiveData;
    }
}
