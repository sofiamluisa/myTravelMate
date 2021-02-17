package com.sofia.mytravelmate;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Vacation.class, exportSchema = false, version = 1)
public abstract class VacationDatabase extends RoomDatabase {
    private static final String DB_NAME = "vacation_db";
    private static VacationDatabase instance;

    public static synchronized VacationDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),VacationDatabase.class, DB_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }
    public abstract VacationDao vacationDao();
}
