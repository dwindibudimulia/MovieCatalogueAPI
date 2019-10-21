package com.example.dwindibudimulia.moviecatalogue.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dwindibudimulia.moviecatalogue.R;
import com.example.dwindibudimulia.moviecatalogue.model.TvShow;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.ViewHolder> {
    private ArrayList<TvShow> tvShows = new ArrayList<>();

    public void setTvShow(ArrayList<TvShow> itemtvShow) {
        tvShows.clear();
        tvShows.addAll(itemtvShow);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tv_show, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowAdapter.ViewHolder holder, int i) {
        holder.onBind(tvShows.get(i));
    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ImgPhotoTv;
        private TextView txtNameTv;
        private TextView txtRatingTv;
        private TextView txtDateTv;
        private TextView txtGenreTv;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ImgPhotoTv = itemView.findViewById(R.id.img_photo_tv);
            txtNameTv = itemView.findViewById(R.id.txt_name_tv);
            txtRatingTv = itemView.findViewById(R.id.txt_rating_tv);
            txtDateTv = itemView.findViewById(R.id.txt_date_tv);
            txtGenreTv = itemView.findViewById(R.id.txt_genre_tv);
        }

        void onBind(TvShow tvShow) {
            txtNameTv.setText(tvShow.getnameTv());
            txtRatingTv.setText(String.valueOf(tvShow.getRatingTv()));
            txtDateTv.setText(tvShow.getdateTv());
            txtGenreTv.setText(tvShow.getgenreTv());
            Glide.with(itemView)
                    .load(tvShow.getPhotoTv())
                    .into(ImgPhotoTv);
        }
    }
}
