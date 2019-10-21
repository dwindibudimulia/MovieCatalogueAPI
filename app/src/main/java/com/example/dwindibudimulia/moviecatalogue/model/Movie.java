package com.example.dwindibudimulia.moviecatalogue.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import org.json.JSONObject;

public class Movie implements Parcelable {

    private String posterPath;

    private String nameMovie;

    private Number ratingMovie;

    private String descriptionMovie;

    private String dateMovie;

    private String genreMovie;

    private String language;

    //JSON
    public Movie(JSONObject movie) {
        try {
            this.nameMovie = movie.getString("original_title");
            this.ratingMovie = (Number) movie.get("vote_average");
            this.descriptionMovie = movie.getString("overview");
            this.dateMovie = movie.getString("release_date");
            this.genreMovie = movie.getString("genre_ids");
            this.language = movie.getString("original_language");
            String poster = movie.getString("poster_path");
            this.posterPath = "https://image.tmdb.org/t/p/w185/" + poster;

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Error Data", e.getMessage());
        }
    }


    // Getter
    public String getnameMovie() {
        return nameMovie;
    }

    public Number getRatingMovie() {
        return ratingMovie;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getgenreMovie() {
        return genreMovie;
    }

    public String getdateMovie() {
        return dateMovie;
    }

    public String getdescriptionMovie() {
        return descriptionMovie;
    }

    public String getLanguage() {
        return language;
    }

    // Setter
    public void setLanguage(String language) {
        this.language = language;
    }


    public void setRatingMovie(Integer ratingMovie) {
        this.ratingMovie = ratingMovie;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }


    public void setgenreMovie(String genreMovie) {
        this.genreMovie = genreMovie;
    }


    public void setdateMovie(String dateMovie) {
        this.dateMovie = dateMovie;
    }


    public void setnameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }


    public void setdescriptionMovie(String descriptionMovie) {
        this.descriptionMovie = descriptionMovie;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.posterPath);
        dest.writeString(this.nameMovie);
        dest.writeSerializable(this.ratingMovie);
        dest.writeString(this.descriptionMovie);
        dest.writeString(this.dateMovie);
        dest.writeString(this.genreMovie);
        dest.writeString(this.language);
    }

    Movie(Parcel in) {
        this.posterPath = in.readString();
        this.nameMovie = in.readString();
        this.ratingMovie = (Number) in.readSerializable();
        this.descriptionMovie = in.readString();
        this.dateMovie = in.readString();
        this.genreMovie = in.readString();
        this.language = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
