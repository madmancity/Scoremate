package com.example.scoremate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BatterSelect extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.batterselect);
        Intent intent = getIntent();
        String team = intent.getStringExtra("team");
        Button back = (Button) findViewById(R.id.backbutton);
        Button cont =  (Button) findViewById(R.id.continuebutton);
        EditText batter1 = (EditText) findViewById(R.id.batter1);
        EditText batter1pos = (EditText) findViewById(R.id.batter1pos);
        EditText batter2 = (EditText) findViewById(R.id.batter2);
        EditText batter2pos = (EditText) findViewById(R.id.batter2pos);
        EditText batter3 = (EditText) findViewById(R.id.batter3);
        EditText batter3pos = (EditText) findViewById(R.id.batter3pos);
        EditText batter4 = (EditText) findViewById(R.id.batter4);
        EditText batter4pos = (EditText) findViewById(R.id.batter4pos);
        EditText batter5 = (EditText) findViewById(R.id.batter5);
        EditText batter5pos = (EditText) findViewById(R.id.batter5pos);
        EditText batter6 = (EditText) findViewById(R.id.batter6);
        EditText batter6pos = (EditText) findViewById(R.id.batter6pos);
        EditText batter7 = (EditText) findViewById(R.id.batter7);
        EditText batter7pos = (EditText) findViewById(R.id.batter7pos);
        EditText batter8 = (EditText) findViewById(R.id.batter8);
        EditText batter8pos = (EditText) findViewById(R.id.batter8pos);
        EditText batter9 = (EditText) findViewById(R.id.batter9);
        EditText batter9pos = (EditText) findViewById(R.id.batter9pos);




        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settings = new Intent(BatterSelect.this, GameSettings.class);
                settings.putExtra("b1n", batter1.getText().toString());
                settings.putExtra("b1p", batter1pos.getText().toString());
                settings.putExtra("b2n", batter2.getText().toString());
                settings.putExtra("b2p", batter2pos.getText().toString());
                settings.putExtra("b3n", batter3.getText().toString());
                settings.putExtra("b3p", batter3pos.getText().toString());
                settings.putExtra("b4n", batter4.getText().toString());
                settings.putExtra("b4p", batter4pos.getText().toString());
                settings.putExtra("b5n", batter5.getText().toString());
                settings.putExtra("b5p", batter5pos.getText().toString());
                settings.putExtra("b6n", batter6.getText().toString());
                settings.putExtra("b6p", batter6pos.getText().toString());
                settings.putExtra("b7n", batter7.getText().toString());
                settings.putExtra("b7p", batter7pos.getText().toString());
                settings.putExtra("b8n", batter8.getText().toString());
                settings.putExtra("b8p", batter8pos.getText().toString());
                settings.putExtra("b9n", batter9.getText().toString());
                settings.putExtra("b9p", batter9pos.getText().toString());

                startActivity(settings);
            }
        });
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent play = new Intent(BatterSelect.this, MainActivity.class);
                play.putExtra("b1n", batter1.getText().toString());
                play.putExtra("b1p", batter1pos.getText().toString());
                play.putExtra("b2n", batter2.getText().toString());
                play.putExtra("b2p", batter2pos.getText().toString());
                play.putExtra("b3n", batter3.getText().toString());
                play.putExtra("b3p", batter3pos.getText().toString());
                play.putExtra("b4n", batter4.getText().toString());
                play.putExtra("b4p", batter4pos.getText().toString());
                play.putExtra("b5n", batter5.getText().toString());
                play.putExtra("b5p", batter5pos.getText().toString());
                play.putExtra("b6n", batter6.getText().toString());
                play.putExtra("b6p", batter6pos.getText().toString());
                play.putExtra("b7n", batter7.getText().toString());
                play.putExtra("b7p", batter7pos.getText().toString());
                play.putExtra("b8n", batter8.getText().toString());
                play.putExtra("b8p", batter8pos.getText().toString());
                play.putExtra("b9n", batter9.getText().toString());
                play.putExtra("b9p", batter9pos.getText().toString());
                play.putExtra("team", team);
                startActivity(play);

            }
        });

    }
}
