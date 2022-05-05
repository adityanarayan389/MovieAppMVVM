package com.example.movieappmvvm;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.transform.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<MovieModel.Result> movieList;
    MovieViewModel movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getMovies();
        getPopularMovies();

    }
    private void getPopularMovies(){
        movieViewModel = new ViewModelProvider(MainActivity.this).get(MovieViewModel.class);
        movieViewModel.getMovieModelMutableLiveData().observe(this, new Observer<MovieModel>() {
            @Override
            public void onChanged(MovieModel movieModel) {
                movieList= new ArrayList<>();
                movieList = movieModel.getResults();
                String name = movieList.get(1).getTitle();

            }
        });

    }

//    public void getMovies(){
//        ApiInterface apIinterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
//        Map<String, Object> prams = new HashMap<>();
//        prams.put("api_key", "3a7c97a5a189239f438797aca4f3afad");
//        Call<MovieModel> getMoviesList = apIinterface.getMovies(prams);
//        getMoviesList.enqueue(new Callback<MovieModel>() {
//            @Override
//            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
//                List<MovieModel.Result> movieList = new ArrayList<>();
//                for (int i = 0 ; i < response.body().getResults().size(); i++ ){
//                    movieList.add(response.body().getResults().get(i));
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<MovieModel> call, Throwable t) {
//
//            }
//        });
//    }


}

