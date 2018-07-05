package com.example.victo.desafiomobile.Game.ListGames;

import com.example.victo.desafiomobile.Game.ListGame;
import com.example.victo.desafiomobile.api.GamesAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListGamesPresenter {

    ListGamesContract.View view;
    private ListGame listGame;

    public ListGamesPresenter(ListGamesContract.View view) {
        this.view = view;
    }

    public void getListGames() {
        final GamesAPI gamesAPI = new GamesAPI();
        gamesAPI.getGames().enqueue(new Callback<ListGame>() {
            @Override
            public void onResponse(Call<ListGame> call, Response<ListGame> response) {
                listGame = response.body();
                view.setListGames(listGame.getGames());
            }

            @Override
            public void onFailure(Call<ListGame> call, Throwable t) {
                view.setMessage();
            }
        });
    }
}

