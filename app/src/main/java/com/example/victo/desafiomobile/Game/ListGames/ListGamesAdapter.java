package com.example.victo.desafiomobile.Game.ListGames;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.victo.desafiomobile.Game.Game;
import com.example.victo.desafiomobile.Game.ListGame;
import com.squareup.picasso.Picasso;

import com.example.victo.desafiomobile.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListGamesAdapter extends RecyclerView.Adapter<ListGamesAdapter.GamesViewHolder> {

    private List<Game> listGames;
    private Context context;
    OnRecyclerItemClick onRecyclerItemClick;

    public ListGamesAdapter(List<Game> listGames, Context context) {
        this.listGames = listGames;
        this.context = context;
    }

    @Override
    public ListGamesAdapter.GamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item_list,parent,false);
        return new GamesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListGamesAdapter.GamesViewHolder holder, int position) {

        Game game = listGames.get(position);
        Picasso.get()
                .load(game.getImage())
                .centerCrop()
                .fit()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return listGames.size();
    }

    public class GamesViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.gameImage)
        ImageView image;

        public GamesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.item_recycler)
        void onItemClick(View view){
            if(onRecyclerItemClick != null){
                onRecyclerItemClick.onClick(view, getAdapterPosition());
            }
        }
    }

    public void setOnRecyclerItemClick(OnRecyclerItemClick onRecyclerItemClick){
        this.onRecyclerItemClick = onRecyclerItemClick;
    }
}
