package com.example.scoremate;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scoremate.DB.DBCell;
import com.example.scoremate.DB.GVM;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

public class Scorecard extends AppCompatActivity {

    // Recycler View object
    RecyclerView recyclerView;
    private static final int PERM_S = 1;

    // Array list for recycler view data source
    ArrayList<AtBat> source;
    private static final String CHANNEL_ID = "channel_id";

    // Layout Manager
    private AlertDialog alertDialog;


    // adapter class object
    Adapter adapter;

    // Linear Layout Manager
    LinearLayoutManager HorizontalLayout1;
    LinearLayoutManager HorizontalLayout2;
    LinearLayoutManager HorizontalLayout3;
    LinearLayoutManager HorizontalLayout4;
    LinearLayoutManager HorizontalLayout5;
    LinearLayoutManager HorizontalLayout6;
    LinearLayoutManager HorizontalLayout7;
    LinearLayoutManager HorizontalLayout8;
    LinearLayoutManager HorizontalLayout9;

    View ChildView;
    int RecyclerViewItemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scorecard);
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET},
                    PERM_S);
        }

        Intent intent = getIntent();
        RecyclerView.LayoutManager RecyclerViewLayoutManager;
        ExtendedFloatingActionButton save = (ExtendedFloatingActionButton) findViewById(R.id.fab);
        FloatingActionButton home = (FloatingActionButton) findViewById(R.id.fabhome);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Scorecard.this, TitleScreen.class);
                startActivity(home);
            }
        });
        save.setIcon(getDrawable(R.drawable.ballicon));
        save.shrink();

        String team = intent.getStringExtra("team");
        ArrayList<AtBat> play1 = (ArrayList<AtBat>) intent.getExtras().getSerializable("play1");
        ArrayList<AtBat> play2 = (ArrayList<AtBat>) intent.getExtras().getSerializable("play2");
        ArrayList<AtBat> play3 = (ArrayList<AtBat>) intent.getExtras().getSerializable("play3");
        ArrayList<AtBat> play4 = (ArrayList<AtBat>) intent.getExtras().getSerializable("play4");
        ArrayList<AtBat> play5 = (ArrayList<AtBat>) intent.getExtras().getSerializable("play5");
        ArrayList<AtBat> play6 = (ArrayList<AtBat>) intent.getExtras().getSerializable("play6");
        ArrayList<AtBat> play7 = (ArrayList<AtBat>) intent.getExtras().getSerializable("play7");
        ArrayList<AtBat> play8 = (ArrayList<AtBat>) intent.getExtras().getSerializable("play8");
        ArrayList<AtBat> play9 = (ArrayList<AtBat>) intent.getExtras().getSerializable("play9");

        String b1n = play1.get(0).getName();
        String b1p = play1.get(0).getPosition();
        String b2n = play2.get(0).getName();
        String b2p = play2.get(0).getPosition();
        String b3n = play3.get(0).getName();
        String b3p = play3.get(0).getPosition();
        String b4n = play4.get(0).getName();
        String b4p = play4.get(0).getPosition();
        String b5n = play5.get(0).getName();
        String b5p = play5.get(0).getPosition();
        String b6n = play6.get(0).getName();
        String b6p = play6.get(0).getPosition();
        String b7n = play7.get(0).getName();
        String b7p = play7.get(0).getPosition();
        String b8n = play8.get(0).getName();
        String b8p = play8.get(0).getPosition();
        String b9n = play9.get(0).getName();
        String b9p = play9.get(0).getPosition();

        TextView p1 = (TextView) findViewById(R.id.player1);
        TextView p2 = (TextView) findViewById(R.id.player2);
        TextView p3 = (TextView) findViewById(R.id.player3);
        TextView p4 = (TextView) findViewById(R.id.player4);
        TextView p5 = (TextView) findViewById(R.id.player5);
        TextView p6 = (TextView) findViewById(R.id.player6);
        TextView p7 = (TextView) findViewById(R.id.player7);
        TextView p8 = (TextView) findViewById(R.id.player8);
        TextView p9 = (TextView) findViewById(R.id.player9);
        p1.setText(b1n + "\n" + b1p);
        p2.setText(b2n + "\n" + b2p);
        p3.setText(b3n + "\n" + b3p);
        p4.setText(b4n + "\n" + b4p);
        p5.setText(b5n + "\n" + b5p);
        p6.setText(b6n + "\n" + b6p);
        p7.setText(b7n + "\n" + b7p);
        p8.setText(b8n + "\n" + b8p);
        p9.setText(b9n + "\n" + b9p);

        CellAdapter p1adapt = new CellAdapter(play1);
        CellAdapter p2adapt = new CellAdapter(play2);
        CellAdapter p3adapt = new CellAdapter(play3);
        CellAdapter p4adapt = new CellAdapter(play4);
        CellAdapter p5adapt = new CellAdapter(play5);
        CellAdapter p6adapt = new CellAdapter(play6);
        CellAdapter p7adapt = new CellAdapter(play7);
        CellAdapter p8adapt = new CellAdapter(play8);
        CellAdapter p9adapt = new CellAdapter(play9);

        HorizontalLayout1
                = new LinearLayoutManager(
                Scorecard.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        HorizontalLayout2
                = new LinearLayoutManager(
                Scorecard.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        HorizontalLayout3
                = new LinearLayoutManager(
                Scorecard.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        HorizontalLayout4
                = new LinearLayoutManager(
                Scorecard.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        HorizontalLayout5
                = new LinearLayoutManager(
                Scorecard.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        HorizontalLayout6
                = new LinearLayoutManager(
                Scorecard.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        HorizontalLayout7
                = new LinearLayoutManager(
                Scorecard.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        HorizontalLayout8
                = new LinearLayoutManager(
                Scorecard.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        HorizontalLayout9
                = new LinearLayoutManager(
                Scorecard.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        GVM mGameViewModel = new GVM(getApplication());
        AlertDialog.Builder builder = new AlertDialog.Builder(Scorecard.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.save_alert, null);
        builder.setView(dialogView);
        EditText date = dialogView.findViewById(R.id.enterdate);
        EditText time = dialogView.findViewById(R.id.entertime);
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Random rand = new Random();
                int min = 1000;
                int max = 9999;
                int randomNum = rand.nextInt((max - min) + 1) + min;
                DBCell cell = new DBCell();
                cell.setGameid(randomNum);
                cell.setPlayer1(play1);
                cell.setPlayer2(play2);
                cell.setPlayer3(play3);
                cell.setPlayer4(play4);
                cell.setPlayer5(play5);
                cell.setPlayer6(play6);
                cell.setPlayer7(play7);
                cell.setPlayer8(play8);
                cell.setPlayer9(play9);
                cell.setTeam(team);
                cell.setDate(date.getText().toString());
                cell.setTime(time.getText().toString());
                mGameViewModel.insertGame(cell);
                Intent save = new Intent(Scorecard.this, GameList.class);
                save.putExtra("play1", play1);
                save.putExtra("play2", play2);
                save.putExtra("play2", play3);
                save.putExtra("play2", play4);
                save.putExtra("play2", play5);
                save.putExtra("play2", play6);
                save.putExtra("play2", play7);
                save.putExtra("play2", play8);
                save.putExtra("play2", play9);
                save.putExtra("team", team);
                save.putExtra("date", date.getText().toString());
                save.putExtra("time", time.getText().toString());
                NotificationCompat.Builder builder = new NotificationCompat.Builder(Scorecard.this, CHANNEL_ID);
                        builder.setSmallIcon(R.drawable.ballicon);
                        builder.setContentTitle("Scorecard");
                        builder.setContentText("Your scorecard was saved to the database");
                        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(Scorecard.this);
                if (ActivityCompat.checkSelfPermission(Scorecard.this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    System.out.print("Damn");
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.

                    return;
                }
                notificationManager.notify(1, builder.build());
                startActivity(save);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                save.shrink();
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(save.isExtended() == false){
                    save.extend();
                } else if (save.isExtended()==true) {
                alertDialog.show();

                }
            }
        });



        // initialisation with id's
        RecyclerView playerscroll1 = (RecyclerView)findViewById(R.id.playerscroll1);
        playerscroll1.setLayoutManager(HorizontalLayout1);

        playerscroll1.setAdapter(p1adapt);
        RecyclerView playerscroll2 = (RecyclerView)findViewById(R.id.playerscroll2);
        playerscroll2.setLayoutManager(HorizontalLayout2);
        playerscroll2.setAdapter(p2adapt);
        RecyclerView playerscroll3 = (RecyclerView)findViewById(R.id.playerscroll3);
        playerscroll3.setLayoutManager(HorizontalLayout3);
        playerscroll3.setAdapter(p3adapt);
        RecyclerView playerscroll4 = (RecyclerView)findViewById(R.id.playerscroll4);
        playerscroll4.setLayoutManager(HorizontalLayout4);
        playerscroll4.setAdapter(p4adapt);
        RecyclerView playerscroll5 = (RecyclerView)findViewById(R.id.playerscroll5);
        playerscroll5.setLayoutManager(HorizontalLayout5);
        playerscroll5.setAdapter(p5adapt);
        RecyclerView playerscroll6 = (RecyclerView)findViewById(R.id.playerscroll6);
        playerscroll6.setLayoutManager(HorizontalLayout6);
        playerscroll6.setAdapter(p6adapt);
        RecyclerView playerscroll7 = (RecyclerView)findViewById(R.id.playerscroll7);
        playerscroll7.setLayoutManager(HorizontalLayout7);
        playerscroll7.setAdapter(p7adapt);
        RecyclerView playerscroll8 = (RecyclerView)findViewById(R.id.playerscroll8);
        playerscroll8.setLayoutManager(HorizontalLayout8);
        playerscroll8.setAdapter(p8adapt);
        RecyclerView playerscroll9 = (RecyclerView)findViewById(R.id.playerscroll9);
        playerscroll9.setLayoutManager(HorizontalLayout9);
        playerscroll9.setAdapter(p9adapt);


        // Adding items to RecyclerView.
        AddItemsToRecyclerViewArrayList();

        // calling constructor of adapter
        // with source list as a parameter

        // Set Horizontal Layout Manager
        // for Recycler view



        // Set adapter on recycler view

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERM_S) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission was granted, continue with the task that requires the permission
            } else {
                // Permission was denied, handle the user's response
            }
        }
    }
    // Function to add items in RecyclerView.
    public void AddItemsToRecyclerViewArrayList()
    {
        // Adding items to ArrayList
        source = new ArrayList<AtBat>();

    }
}