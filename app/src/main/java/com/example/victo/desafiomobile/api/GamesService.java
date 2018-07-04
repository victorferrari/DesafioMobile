package com.example.victo.desafiomobile.api;

import com.example.victo.desafiomobile.Game.ListGame;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GamesService {

    @GET("s/1b7jlwii7jfvuh0/games")
    Call<ListGame> getGames();
}
