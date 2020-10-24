package com.dicoding.picodiploma.submission1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class DetailActivity extends AppCompatActivity {

    TextView tvName, tvDes, tvGenre, tvProduction, tvDuration, tvRelease;
    ImageView ivImg;
    public static final String EXTRA_MOVIE = "EXTRA_MOVIE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        tvName = findViewById(R.id.txt_name);
        tvDes = findViewById(R.id.txt_description);
        ivImg= findViewById(R.id.img_photo);
        tvGenre= findViewById(R.id.tv_genre);
        tvProduction= findViewById(R.id.tv_production);
        tvDuration= findViewById(R.id.tv_duration);
        tvRelease= findViewById(R.id.tv_relaese);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        int img = movie.getImg();
        String text1 = movie.getName();
        String text2 = movie.getDescription();
        String text3 = movie.getGenre();
        String text4 = movie.getProduction();
        String text5 = movie.getDuration();
        String text6 = movie.getRelease();


        Glide.with(this)
                .load(img)
                .transition(withCrossFade())
                .into(ivImg);
        tvName.setText(text1);
        tvDes.setText(text2);
        tvGenre.setText(text3);
        tvProduction.setText(text4);
        tvDuration.setText(text5);
        tvRelease.setText(text6);
        setActionBarTitle(text1);

    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}
