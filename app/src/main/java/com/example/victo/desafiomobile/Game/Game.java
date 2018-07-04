package com.example.victo.desafiomobile.Game;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Game implements Serializable{

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("image")
    private String image;
    @SerializedName("release_date")
    private String release_date;
    @SerializedName("trailer")
    private String trailer;
    @SerializedName("platforms")
    private List<String> platforms;

    public Game(int id, String name, String image, String release_date, String trailer, List<String> platforms) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.release_date = release_date;
        this.trailer = trailer;
        this.platforms = platforms;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getTrailer() {
        return trailer;
    }

    public List<String> getPlatforms() {
        return platforms;
    }
}

