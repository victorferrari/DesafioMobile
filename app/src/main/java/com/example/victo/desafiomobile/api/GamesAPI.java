package com.example.victo.desafiomobile.api;

import android.widget.Toast;

import com.example.victo.desafiomobile.Models.Game;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GamesAPI {

    public GamesAPI() {

        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(GamesService.BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

        GamesService api = retrofit.create(GamesService.class);

        Call<List<Game>> call = api.getGames();

        call.enqueue(new Callback<List<Game>>() {
            @Override
            public void onResponse(Call<List<Game>> call, Response<List<Game>> response) {

            }

            @Override
            public void onFailure(Call<List<Game>> call, Throwable t) {
                Toast.makeText(, "Erro: "+ t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
