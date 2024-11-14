package com.example.scoremate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.scoremate.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
//TODO Optional features=
// TODO (DONE) Notification, Notify user of Scorecard added to database 7.5
//TODO Location sets default team in GameSettings Screen 10
//TODO (DONE) Select Date and Time of game when saving game Scorecard 7.5
//TODO (DONE) Checkboxes (Basepaths and bases) 5
//TODO (DONE) Alert Dialogs for removing scorecards 5
//TODO (DONE) RecyclerView for Scorecard, RecyclerView for DB of scorecards 7.5
//TODO (DONE) tabs for Instructions screen 7.5


public class MainActivity extends AppCompatActivity {

    public boolean hit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            Intent intent = getIntent();
            String team = intent.getStringExtra("team");
            String b1n = intent.getStringExtra("b1n");
            String b1p = intent.getStringExtra("b1p");
            String b2n = intent.getStringExtra("b2n");
            String b2p = intent.getStringExtra("b2p");
            String b3n = intent.getStringExtra("b3n");
            String b3p = intent.getStringExtra("b3p");
            String b4n = intent.getStringExtra("b4n");
            String b4p = intent.getStringExtra("b4p");
            String b5n = intent.getStringExtra("b5n");
            String b5p = intent.getStringExtra("b5p");
            String b6n = intent.getStringExtra("b6n");
            String b6p = intent.getStringExtra("b6p");
            String b7n = intent.getStringExtra("b7n");
            String b7p = intent.getStringExtra("b7p");
            String b8n = intent.getStringExtra("b8n");
            String b8p = intent.getStringExtra("b8p");
            String b9n = intent.getStringExtra("b9n");
            String b9p = intent.getStringExtra("b9p");



        CheckBox first = (CheckBox) findViewById(R.id.htof);
        CheckBox second = (CheckBox) findViewById(R.id.ftos);
        CheckBox third = (CheckBox) findViewById(R.id.stot);
        CheckBox home = (CheckBox) findViewById(R.id.ttoh);
        CheckBox single = (CheckBox) findViewById(R.id.single);
        CheckBox dbl = (CheckBox) findViewById(R.id.dbl);
        CheckBox triple = (CheckBox) findViewById(R.id.triple);
        CheckBox homerun = (CheckBox) findViewById(R.id.homerun);
        CheckBox fo = (CheckBox) findViewById(R.id.FO);
        CheckBox go = (CheckBox) findViewById(R.id.GO);
        CheckBox hbp = (CheckBox) findViewById((R.id.HBP));
        CheckBox bb = (CheckBox) findViewById(R.id.bb);
        CheckBox ks = (CheckBox) findViewById(R.id.kswing);
        CheckBox kl = (CheckBox) findViewById(R.id.klook);
        CheckBox b1 = (CheckBox) findViewById(R.id.ball1);
        CheckBox b2 = (CheckBox) findViewById(R.id.ball2);
        CheckBox b3 = (CheckBox) findViewById(R.id.ball3);
        CheckBox s1 = (CheckBox) findViewById(R.id.strike1);
        CheckBox s2 = (CheckBox) findViewById(R.id.strike2);
        TextView pn = (TextView) findViewById(R.id.playerns);
        TextView ms = (TextView) findViewById(R.id.moundstat);
        TextView ht = (TextView) findViewById(R.id.hit);
        Button back = (Button) findViewById(R.id.mainback);
        Button next = (Button) findViewById(R.id.advance);
        Button viewsc = (Button) findViewById(R.id.viewscorecard);
        TextView lineupn = (TextView) findViewById(R.id.lineupn);
        CheckBox o1 = (CheckBox) findViewById(R.id.out1);
        CheckBox o2 = (CheckBox) findViewById(R.id.out2);
        TextView trunno = (TextView) findViewById(R.id.innbool);
        trunno.setText("1");
        ArrayList<AtBat> play1 = new ArrayList<>();
        ArrayList<AtBat> play2 = new ArrayList<>();
        ArrayList<AtBat> play3 = new ArrayList<>();
        ArrayList<AtBat> play4 = new ArrayList<>();
        ArrayList<AtBat> play5 = new ArrayList<>();
        ArrayList<AtBat> play6 = new ArrayList<>();
        ArrayList<AtBat> play7 = new ArrayList<>();
        ArrayList<AtBat> play8 = new ArrayList<>();
        ArrayList<AtBat> play9 = new ArrayList<>();
        viewsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList<AtBat>> scorecard = new ArrayList<ArrayList<AtBat>>();
                try {
                    String b1nt = play1.get(0).getName();
                    String b1pt = play1.get(0).getPosition();
                    String b2nt = play2.get(0).getName();
                    String b2pt = play2.get(0).getPosition();
                    String b3nt = play3.get(0).getName();
                    String b3pt = play3.get(0).getPosition();
                    String b4nt = play4.get(0).getName();
                    String b4pt = play4.get(0).getPosition();
                    String b5nt = play5.get(0).getName();
                    String b5pt = play5.get(0).getPosition();
                    String b6nt = play6.get(0).getName();
                    String b6pt = play6.get(0).getPosition();
                    String b7nt = play7.get(0).getName();
                    String b7pt = play7.get(0).getPosition();
                    String b8nt = play8.get(0).getName();
                    String b8pt = play8.get(0).getPosition();
                    String b9nt = play9.get(0).getName();
                    String b9pt = play9.get(0).getPosition();
                    scorecard.add(play1);
                    scorecard.add(play2);
                    scorecard.add(play3);
                    scorecard.add(play4);
                    scorecard.add(play5);
                    scorecard.add(play6);
                    scorecard.add(play7);
                    scorecard.add(play8);
                    scorecard.add(play9);
                    Intent intent = new Intent(MainActivity.this, Scorecard.class);
                    intent.putExtra("play1", play1);
                    intent.putExtra("play2", play2);
                    intent.putExtra("play3", play3);
                    intent.putExtra("play4", play4);
                    intent.putExtra("play5", play5);
                    intent.putExtra("play6", play6);
                    intent.putExtra("play7", play7);
                    intent.putExtra("play8", play8);
                    intent.putExtra("play9", play9);
                    intent.putExtra("team", team);
                    startActivity(intent);
                }catch(Exception e){
                    Context context = getApplicationContext();

                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, "Please enter at least 9 Cells", duration);
                    toast.show();

                }



            }
        });
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int i = Integer.parseInt(lineupn.getText().toString());
                        int runno = Integer.parseInt(trunno.getText().toString());
                        int lp;
                        String name;
                        String pos;
                        String hstatus;
                        String mstatus;
                        boolean run;
                        int base;
                        int balls;
                        int strikes;
                        boolean fin;
                        //Items are added/declared in the following order
                        //Lineup pos, Name, Position, hstatus,mstatus runbool, basereached, balls, strikes
                        switch (i) {
                            case 1:
                                fin = false;
                                lp = 1;
                                name = b1n;
                                pos = b1p;

                                mstatus = (ms.getText().toString());
                                hstatus = (ht.getText().toString());

                                if (ms.getText().toString() == "R") {
                                    run = true;
                                } else {
                                    run = false;
                                }

                                if (second.isChecked() == false && first.isChecked() == true) {
                                    base = 1;
                                } else if (second.isChecked() == true && third.isChecked() == false) {
                                    base = 2;

                                } else if (third.isChecked() == true && home.isChecked() == false) {
                                    base = 3;
                                } else if (home.isChecked() == true) {
                                    base = 4;
                                } else {
                                    base = 0;
                                }

                                if (b1.isChecked() == false && ms.getText().toString() != "BB") {
                                    balls = 0;
                                } else if (b1.isChecked() == true && b2.isChecked() == false) {
                                    balls = 1;
                                } else if (b1.isChecked() && b2.isChecked() && b3.isChecked() == false) {
                                    balls = 2;
                                } else if (b1.isChecked() && b2.isChecked() && b3.isChecked()) {
                                    balls = 3;
                                } else {
                                    if (ms.getText().toString() == "BB") {
                                        balls = 4;
                                    } else {
                                        balls = 0;
                                    }
                                }

                                if (s1.isChecked() == false && ms.getText().toString() != "KS" && ms.getText().toString() != "KL") {
                                    strikes = 0;
                                } else if (s1.isChecked() && s2.isChecked() == false) {
                                    strikes = 1;
                                } else if (s1.isChecked() && s2.isChecked()) {
                                    strikes = 2;
                                } else {
                                    if (ms.getText().toString() == "KS" || ms.getText().toString() == "KL") {
                                        strikes = 3;
                                    } else {
                                        strikes = 0;
                                    }
                                }

                                AtBat ab = new AtBat(lp, name, pos, hstatus, mstatus, run, base, balls, strikes, runno);
                                play1.add(ab);


                                pn.setText("  " + b2n + "\n" + "  " + b2p);
                                first.setChecked(false);
                                second.setChecked(false);
                                third.setChecked(false);
                                home.setChecked(false);
                                single.setChecked(false);
                                dbl.setChecked(false);
                                triple.setChecked(false);
                                homerun.setChecked(false);
                                b1.setChecked(false);
                                b2.setChecked(false);
                                b3.setChecked(false);
                                s1.setChecked(false);
                                s2.setChecked(false);
                                ms.setText("");
                                lineupn.setText("2");
                                break;
                            case 2:
                                fin = false;
                                lp = 2;
                                name = b2n;
                                pos = b2p;

                                mstatus = (ms.getText().toString());
                                hstatus = (ht.getText().toString());

                                if (ms.getText().toString() == "R") {
                                    run = true;
                                } else {
                                    run = false;
                                }

                                if (second.isChecked() == false && first.isChecked() == true) {
                                    base = 1;
                                } else if (second.isChecked() == true && third.isChecked() == false) {
                                    base = 2;

                                } else if (third.isChecked() == true && home.isChecked() == false) {
                                    base = 3;
                                } else if (home.isChecked() == true) {
                                    base = 4;
                                } else {
                                    base = 0;
                                }

                                if (b1.isChecked() == false && ms.getText().toString() != "BB") {
                                    balls = 0;
                                } else if (b1.isChecked() == true && b2.isChecked() == false) {
                                    balls = 1;
                                } else if (b1.isChecked() && b2.isChecked() && b3.isChecked() == false) {
                                    balls = 2;
                                } else if (b1.isChecked() && b2.isChecked() && b3.isChecked()) {
                                    balls = 3;
                                } else {
                                    if (ms.getText().toString() == "BB") {
                                        balls = 4;
                                    } else {
                                        balls = 0;
                                    }
                                }

                                if (s1.isChecked() == false && ms.getText().toString() != "KS" && ms.getText().toString() != "KL") {
                                    strikes = 0;
                                } else if (s1.isChecked() && s2.isChecked() == false) {
                                    strikes = 1;
                                } else if (s1.isChecked() && s2.isChecked()) {
                                    strikes = 2;
                                } else {
                                    if (ms.getText().toString() == "KS" || ms.getText().toString() == "KL") {
                                        strikes = 3;
                                    } else {
                                        strikes = 0;
                                    }
                                }
                                AtBat ab2 = new AtBat(lp, name, pos, hstatus, mstatus, run, base, balls, strikes, runno);
                                play2.add(ab2);
                                pn.setText("  " + b3n + "\n" + "  " + b3p);
                                first.setChecked(false);
                                second.setChecked(false);
                                third.setChecked(false);
                                home.setChecked(false);
                                single.setChecked(false);
                                dbl.setChecked(false);
                                triple.setChecked(false);
                                homerun.setChecked(false);
                                b1.setChecked(false);
                                b2.setChecked(false);
                                b3.setChecked(false);
                                s1.setChecked(false);
                                s2.setChecked(false);
                                ms.setText("");
                                lineupn.setText("3");
                                break;
                            case 3:
                                fin = false;
                                lp = 3;
                                name = b3n;
                                pos = b3p;

                                mstatus = (ms.getText().toString());
                                hstatus = (ht.getText().toString());
                                if (ms.getText().toString() == "R") {
                                    run = true;
                                } else {
                                    run = false;
                                }

                                if (second.isChecked() == false && first.isChecked() == true) {
                                    base = 1;
                                } else if (second.isChecked() == true && third.isChecked() == false) {
                                    base = 2;

                                } else if (third.isChecked() == true && home.isChecked() == false) {
                                    base = 3;
                                } else if (home.isChecked() == true) {
                                    base = 4;
                                } else {
                                    base = 0;
                                }

                                if (b1.isChecked() == false && ms.getText().toString() != "BB") {
                                    balls = 0;
                                } else if (b1.isChecked() == true && b2.isChecked() == false) {
                                    balls = 1;
                                } else if (b1.isChecked() && b2.isChecked() && b3.isChecked() == false) {
                                    balls = 2;
                                } else if (b1.isChecked() && b2.isChecked() && b3.isChecked()) {
                                    balls = 3;
                                } else {
                                    if (ms.getText().toString() == "BB") {
                                        balls = 4;
                                    } else {
                                        balls = 0;
                                    }
                                }

                                if (s1.isChecked() == false && ms.getText().toString() != "KS" && ms.getText().toString() != "KL") {
                                    strikes = 0;
                                } else if (s1.isChecked() && s2.isChecked() == false) {
                                    strikes = 1;
                                } else if (s1.isChecked() && s2.isChecked()) {
                                    strikes = 2;
                                } else {
                                    if (ms.getText().toString() == "KS" || ms.getText().toString() == "KL") {
                                        strikes = 3;
                                    } else {
                                        strikes = 0;
                                    }
                                }
                                AtBat ab3 = new AtBat(lp, name, pos, hstatus, mstatus, run, base, balls, strikes, runno);
                                play3.add(ab3);
                                pn.setText("  " + b4n + "\n" + "  " + b4p);
                                first.setChecked(false);
                                second.setChecked(false);
                                third.setChecked(false);
                                home.setChecked(false);
                                single.setChecked(false);
                                dbl.setChecked(false);
                                triple.setChecked(false);
                                homerun.setChecked(false);
                                b1.setChecked(false);
                                b2.setChecked(false);
                                b3.setChecked(false);
                                s1.setChecked(false);
                                s2.setChecked(false);
                                ms.setText("");
                                lineupn.setText("4");
                                break;
                            case 4:
                                fin = false;
                                lp = 4;
                                name = b4n;
                                pos = b4p;

                                mstatus = (ms.getText().toString());
                                hstatus = (ht.getText().toString());

                                if (ms.getText().toString() == "R") {
                                    run = true;
                                } else {
                                    run = false;
                                }

                                if (second.isChecked() == false && first.isChecked() == true) {
                                    base = 1;
                                } else if (second.isChecked() == true && third.isChecked() == false) {
                                    base = 2;

                                } else if (third.isChecked() == true && home.isChecked() == false) {
                                    base = 3;
                                } else if (home.isChecked() == true) {
                                    base = 4;
                                } else {
                                    base = 0;
                                }

                                if (b1.isChecked() == false && ms.getText().toString() != "BB") {
                                    balls = 0;
                                } else if (b1.isChecked() == true && b2.isChecked() == false) {
                                    balls = 1;
                                } else if (b1.isChecked() && b2.isChecked() && b3.isChecked() == false) {
                                    balls = 2;
                                } else if (b1.isChecked() && b2.isChecked() && b3.isChecked()) {
                                    balls = 3;
                                } else {
                                    if (ms.getText().toString() == "BB") {
                                        balls = 4;
                                    } else {
                                        balls = 0;
                                    }
                                }

                                if (s1.isChecked() == false && ms.getText().toString() != "KS" && ms.getText().toString() != "KL") {
                                    strikes = 0;
                                } else if (s1.isChecked() && s2.isChecked() == false) {
                                    strikes = 1;
                                } else if (s1.isChecked() && s2.isChecked()) {
                                    strikes = 2;
                                } else {
                                    if (ms.getText().toString() == "KS" || ms.getText().toString() == "KL") {
                                        strikes = 3;
                                    } else {
                                        strikes = 0;
                                    }
                                }
                                AtBat ab4 = new AtBat(lp, name, pos, hstatus, mstatus, run, base, balls, strikes, runno);
                                play4.add(ab4);
                                pn.setText("  " + b5n + "\n" + "  " + b5p);
                                first.setChecked(false);
                                second.setChecked(false);
                                third.setChecked(false);
                                home.setChecked(false);
                                single.setChecked(false);
                                dbl.setChecked(false);
                                triple.setChecked(false);
                                homerun.setChecked(false);
                                b1.setChecked(false);
                                b2.setChecked(false);
                                b3.setChecked(false);
                                s1.setChecked(false);
                                s2.setChecked(false);
                                ms.setText("");
                                lineupn.setText("5");
                                break;
                            case 5:
                                fin = false;
                                lp = 5;
                                name = b5n;
                                pos = b5p;
                                mstatus = (ms.getText().toString());
                                hstatus = (ht.getText().toString());


                                if (ms.getText().toString() == "R") {
                                    run = true;
                                } else {
                                    run = false;
                                }

                                if (second.isChecked() == false && first.isChecked() == true) {
                                    base = 1;
                                } else if (second.isChecked() == true && third.isChecked() == false) {
                                    base = 2;

                                } else if (third.isChecked() == true && home.isChecked() == false) {
                                    base = 3;
                                } else if (home.isChecked() == true) {
                                    base = 4;
                                } else {
                                    base = 0;
                                }

                                if (b1.isChecked() == false && ms.getText().toString() != "BB") {
                                    balls = 0;
                                } else if (b1.isChecked() == true && b2.isChecked() == false) {
                                    balls = 1;
                                } else if (b1.isChecked() && b2.isChecked() && b3.isChecked() == false) {
                                    balls = 2;
                                } else if (b1.isChecked() && b2.isChecked() && b3.isChecked()) {
                                    balls = 3;
                                } else {
                                    if (ms.getText().toString() == "BB") {
                                        balls = 4;
                                    } else {
                                        balls = 0;
                                    }
                                }

                                if (s1.isChecked() == false && ms.getText().toString() != "KS" && ms.getText().toString() != "KL") {
                                    strikes = 0;
                                } else if (s1.isChecked() && s2.isChecked() == false) {
                                    strikes = 1;
                                } else if (s1.isChecked() && s2.isChecked()) {
                                    strikes = 2;
                                } else {
                                    if (ms.getText().toString() == "KS" || ms.getText().toString() == "KL") {
                                        strikes = 3;
                                    } else {
                                        strikes = 0;
                                    }
                                }
                                AtBat ab5 = new AtBat(lp, name, pos, hstatus, mstatus, run, base, balls, strikes, runno);
                                play5.add(ab5);
                                pn.setText("  " + b6n + "\n" + "  " + b6p);
                                first.setChecked(false);
                                second.setChecked(false);
                                third.setChecked(false);
                                home.setChecked(false);
                                single.setChecked(false);
                                dbl.setChecked(false);
                                triple.setChecked(false);
                                homerun.setChecked(false);
                                b1.setChecked(false);
                                b2.setChecked(false);
                                b3.setChecked(false);
                                s1.setChecked(false);
                                s2.setChecked(false);
                                ms.setText("");
                                lineupn.setText("6");
                                break;
                            case 6:
                                fin = false;
                                lp = 6;
                                name = b6n;
                                pos = b6p;
                                mstatus = (ms.getText().toString());
                                hstatus = (ht.getText().toString());


                                if (ms.getText().toString() == "R") {
                                    run = true;
                                } else {
                                    run = false;
                                }

                                if (second.isChecked() == false && first.isChecked() == true) {
                                    base = 1;
                                } else if (second.isChecked() == true && third.isChecked() == false) {
                                    base = 2;

                                } else if (third.isChecked() == true && home.isChecked() == false) {
                                    base = 3;
                                } else if (home.isChecked() == true) {
                                    base = 4;
                                } else {
                                    base = 0;
                                }

                                if (b1.isChecked() == false && ms.getText().toString() != "BB") {
                                    balls = 0;
                                } else if (b1.isChecked() == true && b2.isChecked() == false) {
                                    balls = 1;
                                } else if (b1.isChecked() && b2.isChecked() && b3.isChecked() == false) {
                                    balls = 2;
                                } else if (b1.isChecked() && b2.isChecked() && b3.isChecked()) {
                                    balls = 3;
                                } else {
                                    if (ms.getText().toString() == "BB") {
                                        balls = 4;
                                    } else {
                                        balls = 0;
                                    }
                                }

                                if (s1.isChecked() == false && ms.getText().toString() != "KS" && ms.getText().toString() != "KL") {
                                    strikes = 0;
                                } else if (s1.isChecked() && s2.isChecked() == false) {
                                    strikes = 1;
                                } else if (s1.isChecked() && s2.isChecked()) {
                                    strikes = 2;
                                } else {
                                    if (ms.getText().toString() == "KS" || ms.getText().toString() == "KL") {
                                        strikes = 3;
                                    } else {
                                        strikes = 0;
                                    }
                                }
                                AtBat ab6 = new AtBat(lp, name, pos, hstatus,mstatus, run, base, balls, strikes, runno);
                                play6.add(ab6);
                                pn.setText("  " + b7n + "\n" + "  " + b7p);
                                first.setChecked(false);
                                second.setChecked(false);
                                third.setChecked(false);
                                home.setChecked(false);
                                single.setChecked(false);
                                dbl.setChecked(false);
                                triple.setChecked(false);
                                homerun.setChecked(false);
                                b1.setChecked(false);
                                b2.setChecked(false);
                                b3.setChecked(false);
                                s1.setChecked(false);
                                s2.setChecked(false);
                                ms.setText("");
                                lineupn.setText("7");
                                break;
                            case 7:
                                fin = false;
                                lp = 7;
                                name = b7n;
                                pos = b7p;

                                mstatus = (ms.getText().toString());
                                hstatus = (ht.getText().toString());

                                if (ms.getText().toString() == "R") {
                                    run = true;
                                } else {
                                    run = false;
                                }

                                if (second.isChecked() == false && first.isChecked() == true) {
                                    base = 1;
                                } else if (second.isChecked() == true && third.isChecked() == false) {
                                    base = 2;

                                } else if (third.isChecked() == true && home.isChecked() == false) {
                                    base = 3;
                                } else if (home.isChecked() == true) {
                                    base = 4;
                                } else {
                                    base = 0;
                                }

                                if (b1.isChecked() == false && ms.getText().toString() != "BB") {
                                    balls = 0;
                                } else if (b1.isChecked() == true && b2.isChecked() == false) {
                                    balls = 1;
                                } else if (b1.isChecked() && b2.isChecked() && b3.isChecked() == false) {
                                    balls = 2;
                                } else if (b1.isChecked() && b2.isChecked() && b3.isChecked()) {
                                    balls = 3;
                                } else {
                                    if (ms.getText().toString() == "BB") {
                                        balls = 4;
                                    } else {
                                        balls = 0;
                                    }
                                }

                                if (s1.isChecked() == false && ms.getText().toString() != "KS" && ms.getText().toString() != "KL") {
                                    strikes = 0;
                                } else if (s1.isChecked() && s2.isChecked() == false) {
                                    strikes = 1;
                                } else if (s1.isChecked() && s2.isChecked()) {
                                    strikes = 2;
                                } else {
                                    if (ms.getText().toString() == "KS" || ms.getText().toString() == "KL") {
                                        strikes = 3;
                                    } else {
                                        strikes = 0;
                                    }
                                }
                                AtBat ab7 = new AtBat(lp, name, pos, hstatus, mstatus, run, base, balls, strikes, runno);
                                play7.add(ab7);
                                pn.setText("  " + b8n + "\n" + "  " + b8p);
                                first.setChecked(false);
                                second.setChecked(false);
                                third.setChecked(false);
                                home.setChecked(false);
                                single.setChecked(false);
                                dbl.setChecked(false);
                                triple.setChecked(false);
                                homerun.setChecked(false);
                                b1.setChecked(false);
                                b2.setChecked(false);
                                b3.setChecked(false);
                                s1.setChecked(false);
                                s2.setChecked(false);
                                ms.setText("");
                                lineupn.setText("8");
                                break;
                            case 8:
                                fin = false;
                                lp = 8;
                                name = b8n;
                                pos = b8p;

                                mstatus = (ms.getText().toString());
                                hstatus = (ht.getText().toString());

                                if (ms.getText().toString() == "R") {
                                    run = true;
                                } else {
                                    run = false;
                                }

                                if (second.isChecked() == false && first.isChecked() == true) {
                                    base = 1;
                                } else if (second.isChecked() == true && third.isChecked() == false) {
                                    base = 2;

                                } else if (third.isChecked() == true && home.isChecked() == false) {
                                    base = 3;
                                } else if (home.isChecked() == true) {
                                    base = 4;
                                } else {
                                    base = 0;
                                }

                                if (b1.isChecked() == false && ms.getText().toString() != "BB") {
                                    balls = 0;
                                } else if (b1.isChecked() == true && b2.isChecked() == false) {
                                    balls = 1;
                                } else if (b1.isChecked() && b2.isChecked() && b3.isChecked() == false) {
                                    balls = 2;
                                } else if (b1.isChecked() && b2.isChecked() && b3.isChecked()) {
                                    balls = 3;
                                } else {
                                    if (ms.getText().toString() == "BB") {
                                        balls = 4;
                                    } else {
                                        balls = 0;
                                    }
                                }

                                if (s1.isChecked() == false && ms.getText().toString() != "KS" && ms.getText().toString() != "KL") {
                                    strikes = 0;
                                } else if (s1.isChecked() && s2.isChecked() == false) {
                                    strikes = 1;
                                } else if (s1.isChecked() && s2.isChecked()) {
                                    strikes = 2;
                                } else {
                                    if (ms.getText().toString() == "KS" || ms.getText().toString() == "KL") {
                                        strikes = 3;
                                    } else {
                                        strikes = 0;
                                    }
                                }
                                AtBat ab8 = new AtBat(lp, name, pos, hstatus, mstatus, run, base, balls, strikes, runno);
                                play8.add(ab8);
                                pn.setText("  " + b9n + "\n" + "  " + b9p);
                                first.setChecked(false);
                                second.setChecked(false);
                                third.setChecked(false);
                                home.setChecked(false);
                                single.setChecked(false);
                                dbl.setChecked(false);
                                triple.setChecked(false);
                                homerun.setChecked(false);
                                b1.setChecked(false);
                                b2.setChecked(false);
                                b3.setChecked(false);
                                s1.setChecked(false);
                                s2.setChecked(false);
                                ms.setText("");
                                lineupn.setText("9");
                                break;
                            case 9:
                                fin = true;
                                lp = 9;
                                name = b9n;
                                pos = b9p;

                                mstatus = (ms.getText().toString());
                                hstatus = (ht.getText().toString());

                                if (ms.getText().toString() == "R") {
                                    run = true;
                                } else {
                                    run = false;
                                }

                                if (second.isChecked() == false && first.isChecked() == true) {
                                    base = 1;
                                } else if (second.isChecked() == true && third.isChecked() == false) {
                                    base = 2;

                                } else if (third.isChecked() == true && home.isChecked() == false) {
                                    base = 3;
                                } else if (home.isChecked() == true) {
                                    base = 4;
                                } else {
                                    base = 0;
                                }

                                if (b1.isChecked() == false && ms.getText().toString() != "BB") {
                                    balls = 0;
                                } else if (b1.isChecked() == true && b2.isChecked() == false) {
                                    balls = 1;
                                } else if (b1.isChecked() && b2.isChecked() && b3.isChecked() == false) {
                                    balls = 2;
                                } else if (b1.isChecked() && b2.isChecked() && b3.isChecked()) {
                                    balls = 3;
                                } else {
                                    if (ms.getText().toString() == "BB") {
                                        balls = 4;
                                    } else {
                                        balls = 0;
                                    }
                                }

                                if (s1.isChecked() == false && ms.getText().toString() != "KS" && ms.getText().toString() != "KL") {
                                    strikes = 0;
                                } else if (s1.isChecked() && s2.isChecked() == false) {
                                    strikes = 1;
                                } else if (s1.isChecked() && s2.isChecked()) {
                                    strikes = 2;
                                } else {
                                    if (ms.getText().toString() == "KS" || ms.getText().toString() == "KL") {
                                        strikes = 3;
                                    } else {
                                        strikes = 0;
                                    }
                                }
                                AtBat ab9 = new AtBat(lp, name, pos, hstatus, mstatus, run, base, balls, strikes, runno);
                                play9.add(ab9);
                                pn.setText("  " + b1n + "\n" + "  " + b1p);
                                first.setChecked(false);
                                second.setChecked(false);
                                third.setChecked(false);
                                home.setChecked(false);
                                single.setChecked(false);
                                dbl.setChecked(false);
                                triple.setChecked(false);
                                homerun.setChecked(false);
                                b1.setChecked(false);
                                b2.setChecked(false);
                                b3.setChecked(false);
                                s1.setChecked(false);
                                s2.setChecked(false);
                                ms.setText("");
                                lineupn.setText("1");

                                break;
                            default:
                                pn.setText("  " + b1n + "\n" + "  " + b1p);
                                first.setChecked(false);
                                second.setChecked(false);
                                third.setChecked(false);
                                home.setChecked(false);
                                single.setChecked(false);
                                dbl.setChecked(false);
                                triple.setChecked(false);
                                homerun.setChecked(false);
                                b1.setChecked(false);
                                b2.setChecked(false);
                                b3.setChecked(false);
                                s1.setChecked(false);
                                s2.setChecked(false);
                                ms.setText("");
                                lineupn.setText("1");

                        }

                    }
                });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settings = new Intent(MainActivity.this, GameSettings.class);
                settings.putExtra("b1n", b1n);
                settings.putExtra("b1p", b1p);
                settings.putExtra("b2n", b2n);
                settings.putExtra("b2p", b2p);
                settings.putExtra("b3n", b3n);
                settings.putExtra("b3p", b3p);
                settings.putExtra("b4n", b4n);
                settings.putExtra("b4p", b4p);
                settings.putExtra("b5n", b5n);
                settings.putExtra("b5p", b5p);
                settings.putExtra("b6n", b6n);
                settings.putExtra("b6p", b6p);
                settings.putExtra("b7n", b7n);
                settings.putExtra("b7p", b7p);
                settings.putExtra("b8n", b8n);
                settings.putExtra("b8p", b8p);
                settings.putExtra("b9n", b9n);
                settings.putExtra("b9p", b9p);

                startActivity(settings);
            }
        });
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(first.isChecked()==false){
                    single.setChecked(false);
                    dbl.setChecked(false);
                    triple.setChecked(false);
                    homerun.setChecked(false);
                    second.setChecked(false);
                    third.setChecked(false);
                    home.setChecked(false);
                }
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(second.isChecked()==false){
                    dbl.setChecked(false);
                    triple.setChecked(false);
                    homerun.setChecked(false);
                    home.setChecked(false);
                    third.setChecked(false);
                }
                else{
                    first.setChecked(true);
                }
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (third.isChecked()==false){
                    home.setChecked(false);
                    triple.setChecked(false);
                    homerun.setChecked(false);

                }
                else{
                    second.setChecked(true);
                    first.setChecked(true);
                    home.setChecked(false);
                }
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(home.isChecked()==false){
                    homerun.setChecked(false);
                }else{
                    third.setChecked(true);
                    second.setChecked(true);
                    first.setChecked(true);
                }
            }
        });
        home.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(home.isChecked()){

                    ms.setText("R");

                }
                else{
                    ms.setText("");

                }
            }
        });
        single.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (single.isChecked()){
                    dbl.setChecked(false);
                    triple.setChecked(false);
                    homerun.setChecked(false);
                    first.setChecked(true);
                    second.setChecked(false);
                    third.setChecked(false);
                    home.setChecked(false);
                    ht.setText("1B");
                    ms.setText("");


                }
                else{
                    first.setChecked(false);
                    ht.setText("");
                    ms.setText("");
                }
            }
        });
        dbl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (dbl.isChecked()){
                    single.setChecked(false);
                    triple.setChecked(false);
                    homerun.setChecked(false);
                    first.setChecked(true);
                    second.setChecked(true);
                    third.setChecked(false);
                    home.setChecked(false);

                    ht.setText("2B");
                    ms.setText("");

                }
                else{
                    second.setChecked(false);
                    first.setChecked(false);
                    ht.setText("");
                    ms.setText("");
                }
            }
        });
        triple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (triple.isChecked()){
                    single.setChecked(false);
                    dbl.setChecked(false);
                    homerun.setChecked(false);
                    first.setChecked(true);
                    second.setChecked(true);
                    third.setChecked(true);
                    home.setChecked(false);

                    ht.setText("3B");
                    ms.setText("");

                }
                else{
                    third.setChecked(false);
                    second.setChecked(false);
                    first.setChecked(false);
                    ht.setText("");
                    ms.setText("");
                }
            }
        });
        homerun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (homerun.isChecked()){
                    single.setChecked(false);
                    dbl.setChecked(false);
                    triple.setChecked(false);
                    first.setChecked(true);
                    second.setChecked(true);
                    third.setChecked(true);
                    home.setChecked(true);

                    ht.setText("HR");

                }
                else{
                    home.setChecked(false);
                    third.setChecked(false);
                    second.setChecked(false);
                    first.setChecked(false);
                    ht.setText("");
                    ms.setText("");
                }
            }
        });
        hbp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ms.setText("HBP");
                first.setChecked(true);
                second.setChecked(false);
                third.setChecked(false);
                home.setChecked(false);
                single.setChecked(false);
                dbl.setChecked(false);
                triple.setChecked(false);
                homerun.setChecked(false);

        }

        });
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ms.setText("BB");
                first.setChecked(true);
                second.setChecked(false);
                third.setChecked(false);
                home.setChecked(false);
                single.setChecked(false);
                dbl.setChecked(false);
                triple.setChecked(false);
                homerun.setChecked(false);
            }
        });
        fo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ms.setText("FO");
                first.setChecked(false);
                second.setChecked(false);
                third.setChecked(false);
                home.setChecked(false);
                single.setChecked(false);
                dbl.setChecked(false);
                triple.setChecked(false);
                homerun.setChecked(false);
                if (o1.isChecked()==false && o2.isChecked()==false){
                    o1.setChecked(true);
                } else if (o1.isChecked() && o2.isChecked()==false) {
                    o2.setChecked(true);
                }
                else{
                    o1.setChecked(false);
                    o2.setChecked(false);
                }

            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ms.setText("GO");
                first.setChecked(false);
                second.setChecked(false);
                third.setChecked(false);
                home.setChecked(false);
                single.setChecked(false);
                dbl.setChecked(false);
                triple.setChecked(false);
                homerun.setChecked(false);
                if (o1.isChecked()==false && o2.isChecked()==false){
                    o1.setChecked(true);
                } else if (o1.isChecked() && o2.isChecked()==false) {
                    o2.setChecked(true);
                }
                else{
                    o1.setChecked(false);
                    o2.setChecked(false);
                }

            }
        });
        ks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ms.setText("KS");
                first.setChecked(false);
                second.setChecked(false);
                third.setChecked(false);
                home.setChecked(false);
                single.setChecked(false);
                dbl.setChecked(false);
                triple.setChecked(false);
                homerun.setChecked(false);
            }
        });
        kl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ms.setText("KL");
                first.setChecked(false);
                second.setChecked(false);
                third.setChecked(false);
                home.setChecked(false);
                single.setChecked(false);
                dbl.setChecked(false);
                triple.setChecked(false);
                homerun.setChecked(false);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b1.isChecked()==false && b2.isChecked()==false){
                    b1.setChecked(false);
                    b2.setChecked(false);
                    b3.setChecked(false);
                }else {
                    b1.setChecked(true);
                    b2.setChecked(false);
                    b3.setChecked(false);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b2.isChecked()==false && b3.isChecked()==false){
                    b1.setChecked(false);
                    b2.setChecked(false);
                    b3.setChecked(false);
                }else {
                    b1.setChecked(true);
                    b2.setChecked(true);
                    b3.setChecked(false);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b3.isChecked()==false){
                    b1.setChecked(false);
                    b2.setChecked(false);
                    b3.setChecked(false);
                }else {
                    b1.setChecked(true);
                    b2.setChecked(true);
                    b3.setChecked(true);
                }
            }
        });
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s1.isChecked()==false && s2.isChecked()==false){
                    s1.setChecked(false);
                    s2.setChecked(false);
                }else{
                    s1.setChecked(true);
                    s2.setChecked(false);
                }
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s2.isChecked()==false){
                    s1.setChecked(false);
                    s2.setChecked(false);
                }else{
                    s1.setChecked(true);
                    s2.setChecked(true);
                }
            }
        });



    }

}