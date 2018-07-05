package com.example.victo.desafiomobile.Game.ListGames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.victo.desafiomobile.Game.Game;
import com.example.victo.desafiomobile.R;
import com.example.victo.desafiomobile.Game.GameDetails.GamesDetailsActivity;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ListGamesActivity extends AppCompatActivity implements ListGamesContract.View{

    @BindView(R.id.rv_games)
    RecyclerView recyclerView;

    @BindView(R.id.progressbar)
    ProgressBar progressbar;

    private ListGamesAdapter adapter;
    ListGamesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        ButterKnife.bind(this);
        presenter = new ListGamesPresenter(this);
        presenter.getListGames();

        setTitle("Lista de Games");
    }

    @Override
    public void setListGames(final List<Game> listGames) {
        progressbar.setVisibility(View.VISIBLE);
        adapter = new ListGamesAdapter(listGames, getApplicationContext());
        adapter.setOnRecyclerItemClick(new OnRecyclerItemClick() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), GamesDetailsActivity.class);
                intent.putExtra("detail", listGames.get(position));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        progressbar.setVisibility(View.GONE);
    }

    @Override
    public void setMessage() {
        Toast.makeText(getApplicationContext(),"Falha no acesso ao servidor", Toast.LENGTH_SHORT).show();
        progressbar.setVisibility(View.GONE);
    }
}
