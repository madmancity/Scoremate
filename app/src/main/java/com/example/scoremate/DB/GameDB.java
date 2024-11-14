package com.example.scoremate.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.scoremate.DB.DBCell;
import com.example.scoremate.DB.DBDAO;
import com.example.scoremate.TypeCon;

@Database(entities = DBCell.class,version=2,exportSchema = false)
@TypeConverters({TypeCon.class})
public abstract class GameDB extends RoomDatabase {

    private static GameDB INSTANCE;
    public abstract DBDAO dDAO();

    static GameDB getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (GameDB.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), GameDB.class, "order_db")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();

                }
            }
        }

        return INSTANCE;
    }

}