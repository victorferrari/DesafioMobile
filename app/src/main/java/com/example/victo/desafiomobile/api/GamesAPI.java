package com.example.victo.desafiomobile.api;


import com.example.victo.desafiomobile.Game.ListGame;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GamesAPI {

    private static GamesAPI instance;
    private GamesService gamesService;

    public static GamesAPI getInstance(){
        if(instance == null){
            instance = new GamesAPI();
        }
        return instance;
    }

    private GamesAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dl.dropboxusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.gamesService = retrofit.create(GamesService.class);
    }

    /*private Converter.Factory defaultConvertFactory() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat("dd-MM-yyyy'T'HH:mm:ss")
                .create();
        return GsonConverterFactory.create(gson);
    }*/

    public Call<ListGame> getGames(){
        return gamesService.getGames();
    }
}
