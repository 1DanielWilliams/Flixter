package com.example.flixter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.flixter.models.Movie;

import org.parceler.Parcels;

import java.util.List;

public class MovieDetailsActivity extends AppCompatActivity {

    Movie movie;

    //the view objects
    TextView tvTitleDetails;
    TextView tvOverviewDetails;
    RatingBar rbVoteAverage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        tvTitleDetails = findViewById(R.id.tvTitleDetails);
        tvOverviewDetails = findViewById(R.id.tvOverviewDetails);
        rbVoteAverage = findViewById(R.id.rbVoteAverage);

        // unwrap the movie passed in via intent, using its simple name as a key
        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Showing details for '%s'", movie.getTitle()));

        //set the title and overviewtv
        tvTitleDetails.setText(movie.getTitle());
        tvOverviewDetails.setText(movie.getOverview());

        float voteAverage = movie.getVoteAverage().floatValue();

        rbVoteAverage.setRating(voteAverage / 2.0f);

    }
}