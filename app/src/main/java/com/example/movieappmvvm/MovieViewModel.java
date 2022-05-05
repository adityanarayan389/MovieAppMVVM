package com.example.movieappmvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MovieViewModel extends ViewModel {
    private MutableLiveData<MovieModel> movieModelMutableLiveData;
    private MovieRepository movieRepository;

    public MovieViewModel(){
        movieRepository = new MovieRepository();
    }

    public MutableLiveData<MovieModel> getMovieModelMutableLiveData() {
        if (movieModelMutableLiveData == null){
            movieModelMutableLiveData = movieRepository.getMoviesList();
        }

        return movieModelMutableLiveData;
    }
}
