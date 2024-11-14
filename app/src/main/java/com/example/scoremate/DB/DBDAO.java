package com.example.scoremate.DB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DBDAO {

    @Query("SELECT * FROM games")
    LiveData<List<DBCell>> getAllGames();

    @Query("DELETE FROM games WHERE gameid = :gameid")
    void deleteByGameId(int gameid);

    @Query("DELETE FROM games")
    void nukeTable();

    @Insert
    void addGame(DBCell cell);

}
