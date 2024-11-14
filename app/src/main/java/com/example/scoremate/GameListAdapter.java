package com.example.scoremate;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.scoremate.DB.DBCell;
import com.example.scoremate.DB.GVM;


import java.util.List;

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.GameViewHolder>{
    private static GVM gvm;
    private List<DBCell> mGameList;
    private final LayoutInflater mInflater;


    class GameViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public final TextView gameid;
        public final TextView team;
        public final TextView date;



        public final TextView time;

        final GameListAdapter mAdapter;




        public GameViewHolder(View itemView, GameListAdapter adapter) {
            super(itemView);
            gameid = itemView.findViewById(R.id.gameid);
            team = itemView.findViewById(R.id.gameteam);
            date = itemView.findViewById(R.id.gamedate);
            time = itemView.findViewById(R.id.gametime);


            itemView.findViewById(R.id.deletebutton).setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    gvm.deleteByGameId(Integer.parseInt(gameid.getText().toString().substring(4)));
                }
            });
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();

            // Use that to access the affected item in mWordList.
            DBCell element = mGameList.get(mPosition);
            // Change the word in the mWordList.
        }
    }



    public void setOrders(List<DBCell> gameList){
        mGameList = gameList;
        notifyDataSetChanged();
    }

    public GameListAdapter(Context context, GVM mGameViewModel) {

        mInflater = LayoutInflater.from(context);
        gvm = mGameViewModel;
    }

    @Override
    public GameListAdapter.GameViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        // Inflate an item view.
        View mItemView = mInflater.inflate(
                R.layout.game_item, parent, false);
        return new GameViewHolder(mItemView, this);
    }


    @Override
    public void onBindViewHolder(GameListAdapter.GameViewHolder holder,
                                 int position) {
        // Retrieve the data for that position.
        DBCell mCurrent = mGameList.get(position);
        int gid = (mCurrent.getGameid());
        String oidstr = String.valueOf(gid);

        // Add the data to the view holder.
        holder.gameid.setText("ID: " + oidstr);
        holder.team.setText("Team: " + mCurrent.getTeam());
        holder.date.setText("Date: " + mCurrent.getDate());
        holder.time.setText("Time: " + mCurrent.getTime());

    }


    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        if(mGameList == null){
            return 0;
        }
        return mGameList.size();
    }
}
