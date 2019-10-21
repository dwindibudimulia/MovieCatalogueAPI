package com.example.dwindibudimulia.moviecatalogue.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import org.json.JSONObject;

public class TvShow implements Parcelable {
    private String photoTv;

    private String nameTv;

    private Number ratingTv;

    private String descriptionTv;

    private String dateTv;

    private String genreTv;

    private String language;

    // Getter
    public String getLangauage() {
        return language;

    }

    public Number getRatingTv() {
        return ratingTv;
    }

    public String getgenreTv() {
        return genreTv;
    }

    public String getPhotoTv() {
        return photoTv;
    }

    public String getnameTv() {
        return nameTv;
    }

    public String getdescriptionTv() {
        return descriptionTv;
    }

    public String getdateTv() {
        return dateTv;
    }

    // Setter

    public void setLangauage(String langauage) {
        this.language = langauage;
    }

    public void setRatingTv(Number ratingTv) {
        this.ratingTv = ratingTv;
    }

    public void setgenreTv(String genreTv) {

        this.genreTv = genreTv;
    }

    public void setPhotoTv(String photoTv) {
        this.photoTv = photoTv;
    }

    public void setnameTv(String nameTv) {
        this.nameTv = nameTv;
    }

    public void setdescriptionTv(String descriptionTv) {
        this.descriptionTv = descriptionTv;
    }

    public void setdateTv(String dateTv) {
        this.dateTv = dateTv;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.photoTv);
        dest.writeString(this.nameTv);
        dest.writeSerializable(this.ratingTv);
        dest.writeString(this.descriptionTv);
        dest.writeString(this.dateTv);
        dest.writeString(this.genreTv);
        dest.writeString(this.language);
    }

    // JSON
    public TvShow(JSONObject tvshow) {
        try {
            this.nameTv = tvshow.getString("name");
            this.ratingTv = (Number) tvshow.get("vote_average");
            this.dateTv = tvshow.getString("first_air_date");
            this.genreTv = tvshow.getString("genre_ids");
            this.descriptionTv = tvshow.getString("overview");
            this.language = tvshow.getString("original_language");
            String photoTv = tvshow.getString("poster_path");
            this.photoTv = "https://image.tmdb.org/t/p/w185/" + photoTv;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Error Data", e.getMessage());
        }
    }

    TvShow(Parcel in) {
        this.photoTv = in.readString();
        this.nameTv = in.readString();
        this.ratingTv = (Number) in.readSerializable();
        this.descriptionTv = in.readString();
        this.dateTv = in.readString();
        this.genreTv = in.readString();
        this.language = in.readString();
    }

    public static final Parcelable.Creator<TvShow> CREATOR = new Parcelable.Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel source) {
            return new TvShow(source);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };
}
