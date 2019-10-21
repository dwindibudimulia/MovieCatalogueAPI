package com.example.dwindibudimulia.moviecatalogue.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.dwindibudimulia.moviecatalogue.R;
import com.example.dwindibudimulia.moviecatalogue.model.TvShow;


public class TvShowDetailActivity extends AppCompatActivity {

    public static final String EXTRA_TV_SHOW = "extra_tv_show";

    private TextView txtNameTv;
    private TextView txtRatingTv;
    private TextView txtDescriptionTv;
    private TextView txtDateTv;
    private TextView txtGenreTv;
    private ImageView imgPhotoTv;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_tv_show_detail);

        txtNameTv = findViewById(R.id.txt_name_tv);
        txtRatingTv = findViewById(R.id.txt_rating_tv);
        txtDescriptionTv = findViewById(R.id.txt_description_tv);
        txtDateTv = findViewById(R.id.txt_date_tv);
        txtGenreTv = findViewById(R.id.txt_genre_tv);
        imgPhotoTv = findViewById(R.id.img_photo_tv);

        TvShow tvShowAdapter = getIntent().getParcelableExtra(EXTRA_TV_SHOW);

        txtNameTv.setText(tvShowAdapter.getnameTv());
        txtRatingTv.setText(String.valueOf(tvShowAdapter.getRatingTv()));
        txtDescriptionTv.setText(tvShowAdapter.getdescriptionTv());
        txtDateTv.setText(tvShowAdapter.getdateTv());
        txtGenreTv.setText(tvShowAdapter.getgenreTv());
        Glide.with(this)
                .load(tvShowAdapter.getPhotoTv())
                .into(imgPhotoTv);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(tvShowAdapter.getnameTv());
        }
    }
}
