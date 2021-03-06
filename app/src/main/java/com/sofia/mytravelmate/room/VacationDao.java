package com.sofia.mytravelmate.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.sofia.mytravelmate.Vacation;

import java.util.List;

@Dao
public interface VacationDao {

    @Query("Select * from vacation")
    List<Vacation> getVacationList();

    @Insert
    void insertVacation(Vacation vacation);

    @Update
    void updateVacation(Vacation vacation);

    @Delete
    void deleteVacation(Vacation vacation);
}
