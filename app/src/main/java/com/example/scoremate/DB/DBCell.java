package com.example.scoremate.DB;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.scoremate.AtBat;

import java.util.ArrayList;


@Entity(tableName = "games")
public class DBCell{

    @PrimaryKey(autoGenerate = false)
    @NonNull
    private int gameid;

    @ColumnInfo(name = "player1")
    private ArrayList<AtBat> player1;
    @ColumnInfo(name = "player2")
    private ArrayList<AtBat> player2;
    @ColumnInfo(name = "player3")
    private ArrayList<AtBat> player3;
    @ColumnInfo(name = "player4")
    private ArrayList<AtBat> player4;
    @ColumnInfo(name = "player5")
    private ArrayList<AtBat> player5;
    @ColumnInfo(name = "player6")
    private ArrayList<AtBat> player6;
    @ColumnInfo(name = "player7")
    private ArrayList<AtBat> player7;
    @ColumnInfo(name = "player8")
    private ArrayList<AtBat> player8;
    @ColumnInfo(name = "player9")
    private ArrayList<AtBat> player9;
    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "time")
    private String time;

    @ColumnInfo(name = "team")
    private String team;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public ArrayList<AtBat> getPlayer1() {
        return player1;
    }

    public void setPlayer1(ArrayList<AtBat> player1) {
        this.player1 = player1;
    }

    public ArrayList<AtBat> getPlayer2() {
        return player2;
    }

    public void setPlayer2(ArrayList<AtBat> player2) {
        this.player2 = player2;
    }

    public ArrayList<AtBat> getPlayer3() {
        return player3;
    }

    public void setPlayer3(ArrayList<AtBat> player3) {
        this.player3 = player3;
    }

    public ArrayList<AtBat> getPlayer4() {
        return player4;
    }

    public void setPlayer4(ArrayList<AtBat> player4) {
        this.player4 = player4;
    }

    public ArrayList<AtBat> getPlayer5() {
        return player5;
    }

    public void setPlayer5(ArrayList<AtBat> player5) {
        this.player5 = player5;
    }

    public ArrayList<AtBat> getPlayer6() {
        return player6;
    }

    public void setPlayer6(ArrayList<AtBat> player6) {
        this.player6 = player6;
    }

    public ArrayList<AtBat> getPlayer7() {
        return player7;
    }

    public void setPlayer7(ArrayList<AtBat> player7) {
        this.player7 = player7;
    }

    public ArrayList<AtBat> getPlayer8() {
        return player8;
    }

    public void setPlayer8(ArrayList<AtBat> player8) {
        this.player8 = player8;
    }

    public ArrayList<AtBat> getPlayer9() {
        return player9;
    }

    public void setPlayer9(ArrayList<AtBat> player9) {
        this.player9 = player9;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
