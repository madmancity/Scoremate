package com.example.scoremate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.scoremate.DB.DBCell;
import com.example.scoremate.DB.GVM;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class GameList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_list);

        Intent intent = getIntent();
        try {
            ArrayList<AtBat> play1 = (ArrayList<AtBat>) intent.getExtras().getSerializable("play1");
            ArrayList<AtBat> play2 = (ArrayList<AtBat>) intent.getExtras().getSerializable("play2");
            ArrayList<AtBat> play3 = (ArrayList<AtBat>) intent.getExtras().getSerializable("play3");
            ArrayList<AtBat> play4 = (ArrayList<AtBat>) intent.getExtras().getSerializable("play4");
            ArrayList<AtBat> play5 = (ArrayList<AtBat>) intent.getExtras().getSerializable("play5");
            ArrayList<AtBat> play6 = (ArrayList<AtBat>) intent.getExtras().getSerializable("play6");
            ArrayList<AtBat> play7 = (ArrayList<AtBat>) intent.getExtras().getSerializable("play7");
            ArrayList<AtBat> play8 = (ArrayList<AtBat>) intent.getExtras().getSerializable("play8");
            ArrayList<AtBat> play9 = (ArrayList<AtBat>) intent.getExtras().getSerializable("play9");

        String team = intent.getStringExtra("team");
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");
    } catch(Exception e){

        }

        ExtendedFloatingActionButton mainmenu = (ExtendedFloatingActionButton) findViewById(R.id.fablist);
        mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainmenu = new Intent(GameList.this, TitleScreen.class);
                startActivity(mainmenu);
            }
        });
        RecyclerView mRecyclerview = findViewById(R.id.gamescroll);
        GVM mGameViewModel = new GVM(getApplication());
        GameListAdapter adapter = new GameListAdapter(this, mGameViewModel);
        mRecyclerview.setAdapter(adapter);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));



        mGameViewModel.getAllGames().observe(this, new Observer<List<DBCell>>() {
            @Override
            public void onChanged(List<DBCell> games) {
                adapter.setOrders(games);
            }
        });




    }

}