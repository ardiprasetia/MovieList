package com.dicoding.picodiploma.submission1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.os.Looper.prepare;

public class MainActivity extends AppCompatActivity {


    private String[] dataNameMovie;
    private String[] dataGenreMovie;
    private String[] dataProductionMovie;
    private String[] dataDurationMovie;
    private String[] dataReleaseMovie;
    private String[] dataDescriptionMovie;
    private TypedArray dataphotoMovie;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    private String title = "Movie Catalogue";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
setActionBarTitle(title);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_movie);
        listView.setAdapter(adapter);

        preparetion();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, movies.get(i).getName(), Toast.LENGTH_SHORT).show();
                Movie movie = new Movie();
                movie.setImg(dataphotoMovie.getResourceId(i, -1));
                movie.setName(dataNameMovie[i]);
                movie.setDescription(dataDescriptionMovie[i]);
                movie.setGenre(dataGenreMovie[i]);
                movie.setProduction(dataProductionMovie[i]);
                movie.setDuration(dataDurationMovie[i]);
                movie.setRelease(dataReleaseMovie[i]);
                Intent moveWithObjectIntent = new Intent(MainActivity.this, DetailActivity.class);
                moveWithObjectIntent.putExtra(DetailActivity.EXTRA_MOVIE, movie);
                startActivity(moveWithObjectIntent);
            }
        });
    }

    private void preparetion() {
        dataphotoMovie = getResources().obtainTypedArray(R.array.data_movie_photo);
        dataNameMovie = getResources().getStringArray(R.array.data_movies_name);
        dataDescriptionMovie = getResources().getStringArray(R.array.data_movies_description);
        dataGenreMovie = getResources().getStringArray(R.array.data_movie_genre);
        dataProductionMovie = getResources().getStringArray(R.array.data_movie_production);
        dataDurationMovie = getResources().getStringArray(R.array.data_movie_duration);
        dataReleaseMovie = getResources().getStringArray(R.array.data_movie_relaese);
    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < dataNameMovie.length; i++) {
            Movie movie = new Movie();
            movie.setImg(dataphotoMovie.getResourceId(i, -1));
            movie.setName(dataNameMovie[i]);
            movie.setDescription(dataDescriptionMovie[i]);
            movie.setGenre(dataGenreMovie[i]);
            movie.setProduction(dataProductionMovie[i]);
            movie.setDuration(dataDurationMovie[i]);
            movie.setRelease(dataReleaseMovie[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }
    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

}
