package com.example.victo.desafiomobile.Game.GameDetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.victo.desafiomobile.R;
import com.example.victo.desafiomobile.Game.Game;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GamesDetailsActivity extends AppCompatActivity {

    @BindView(R.id.detailsImage)
    ImageView imageView;

    @BindView(R.id.detailsName)
    TextView name;

    @BindView(R.id.detailsReleaseDate)
    TextView date;

    @BindView(R.id.detailsPlatforms)
    TextView platforms;

    private Game game;
    private String plataformas = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_details);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("detail");

        setTitle(game.getName());

        Picasso.get()
                .load(game.getImage())
                .centerCrop()
                .fit()
                .into(imageView);

        name.setText(game.getName());
        date.setText(game.getRelease_date());

        for(int i=0; i<game.getPlatforms().size(); i++){
            if(i == 0)
                plataformas = game.getPlatforms().get(i);
            else
                plataformas = plataformas + ", " + game.getPlatforms().get(i);
        }
        platforms.setText(plataformas);
    }
}
