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
import com.example.dwindibudimulia.moviecatalogue.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private ArrayList<Movie> movies = new ArrayList<>();

    public void setMovies(ArrayList<Movie> itemMovie) {
        movies.clear();
        movies.addAll(itemMovie);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int i) {
        holder.onBind(movies.get(i));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPhoto;
        private TextView txtName;
        private TextView txtRating;
        private TextView txtDate;
        private TextView txtGenre;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_photo);
            txtName = itemView.findViewById(R.id.txt_name);
            txtRating = itemView.findViewById(R.id.txt_rating);
            txtDate = itemView.findViewById(R.id.txt_date);
            txtGenre = itemView.findViewById(R.id.txt_genre);
        }

        void onBind(Movie item) {
            txtName.setText(item.getnameMovie());
            txtDate.setText(item.getdateMovie());
            txtRating.setText(String.valueOf(item.getRatingMovie()));
            txtGenre.setText(item.getgenreMovie());
            Glide.with(itemView)
                    .load(item.getPosterPath())
                    .into(imgPhoto);
        }
    }
}
