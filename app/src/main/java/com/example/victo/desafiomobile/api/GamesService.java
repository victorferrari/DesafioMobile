package com.example.victo.desafiomobile.api;

import com.example.victo.desafiomobile.Models.Game;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GamesService {

    String BASE_URL = "https://dl.dropboxusercontent.com/s/1b7jlwii7jfvuh0/";

    @GET("games")
    Call<List<Game>> getGames();
}
