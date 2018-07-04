package com.example.victo.desafiomobile.Game.ListGames;

import com.example.victo.desafiomobile.Game.Game;
import java.util.List;

public interface ListGamesContract {

    interface View {
        void setListGames(List<Game> listGames);
        void setMessage();
    }
}
