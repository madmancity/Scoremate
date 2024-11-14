package com.example.scoremate.DB;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {
    private DBDAO rDAO;

    Repository(Application application){
        GameDB rDB = GameDB.getDatabase(application);
        rDAO = rDB.dDAO();
    }

    public LiveData<List<DBCell>> getAllGames(){
        return rDAO.getAllGames();
    }

    public void nukeTable() {
        rDAO.nukeTable();
    }
    public void deleteByGameId(int oid){
        rDAO.deleteByGameId(oid);
    }

    public void insert(DBCell game){
        new insertOrderAsyncTask(rDAO).execute(game);
    }

    private static class insertOrderAsyncTask extends AsyncTask<DBCell, Void, Void> {

        private DBDAO rAsyncTaskDAO;

        insertOrderAsyncTask(DBDAO dao){
            rAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(DBCell... games) {
            rAsyncTaskDAO.addGame(games[0]);
            return null;
        }
    }
}
