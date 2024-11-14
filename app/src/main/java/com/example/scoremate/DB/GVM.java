package com.example.scoremate.DB;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
public class GVM extends AndroidViewModel {
    private Repository mRepository;

    public GVM(@NonNull Application application){
    super(application);
    mRepository = new Repository(application);
    }

    public LiveData<List<DBCell>> getAllGames(){
    return mRepository.getAllGames();
    }

    public void nukeTable() {mRepository.nukeTable();}
    public void deleteByGameId(int gameid){mRepository.deleteByGameId(gameid);}
    public void insertGame(DBCell game) {mRepository.insert(game);}
}
