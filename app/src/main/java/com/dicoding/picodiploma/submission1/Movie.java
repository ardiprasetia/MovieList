package com.dicoding.picodiploma.submission1;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int img;
    private String name;
    private String description;
    private String genre;
    private String production;
    private String duration;
    private String release;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.img);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.genre);
        dest.writeString(this.production);
        dest.writeString(this.duration);
        dest.writeString(this.release);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.img = in.readInt();
        this.name = in.readString();
        this.description = in.readString();
        this.genre = in.readString();
        this.production = in.readString();
        this.duration = in.readString();
        this.release = in.readString();
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
