package com.example.movieappmvvm;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiInterface {
    @GET("/3/movie/popular")
    Call<MovieModel> getMovies(@QueryMap Map<String,Object> options);
}
