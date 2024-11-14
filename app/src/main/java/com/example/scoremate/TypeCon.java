package com.example.scoremate;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class TypeCon {
    @TypeConverter
    public static ArrayList<AtBat> fromString(String value) {
        Type listType = new TypeToken<ArrayList<AtBat>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<AtBat> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
