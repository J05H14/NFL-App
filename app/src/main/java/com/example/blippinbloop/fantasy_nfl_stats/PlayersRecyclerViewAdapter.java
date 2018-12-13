package com.example.blippinbloop.fantasy_nfl_stats;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.blippinbloop.fantasy_nfl_stats.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayersRecyclerViewAdapter extends RecyclerView.Adapter<PlayersRecyclerViewAdapter.PlayersHolder> {

    Context mContext;
    List<Player> mPlayers;

    public PlayersRecyclerViewAdapter(Context context, ArrayList<Player> players){
        this.mContext = context;
        this.mPlayers = players;
    }

    @NonNull
    @Override
    public PlayersRecyclerViewAdapter.PlayersHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.player_list, parent,shouldAttachToParentImmediately);
        PlayersHolder playerHolder = new PlayersHolder(view);

        return playerHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlayersRecyclerViewAdapter.PlayersHolder playersHolder, int i) {
        playersHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return mPlayers.size();
    }
    public class PlayersHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView description;
        TextView date;
        ImageView img;

        public PlayersHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.name);
            description = (TextView) itemView.findViewById(R.id.position);
            date = (TextView) itemView.findViewById(R.id.team);

            itemView.setOnClickListener(this);
        }

        void bind(int listIndex) {
            final String NAME = mPlayers.get(listIndex).getFirstName() + " " + mPlayers.get(listIndex).getLastName();
            final String POS = mPlayers.get(listIndex).getPos();
            final String TEAM = mPlayers.get(listIndex).getTeam();

            title.setText(NAME);
            description.setText(POS);
            date.setText(TEAM);

        }

        @Override
        public void onClick(View view) {
//            String urlString = mNewsItems.get(getAdapterPosition()).getUrl();
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
//            mContext.startActivity(intent);
        }
    }
}
