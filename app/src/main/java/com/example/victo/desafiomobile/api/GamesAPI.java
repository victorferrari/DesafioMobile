package com.example.victo.desafiomobile.api;


import com.example.victo.desafiomobile.Game.ListGame;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GamesAPI {

    private GamesService gamesService;

    public GamesAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dl.dropboxusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.gamesService = retrofit.create(GamesService.class);
    }

    public Call<ListGame> getGames(){
        return gamesService.getGames();
    }
}
