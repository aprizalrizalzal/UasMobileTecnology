package com.tamanmandiri.orderfoodanddrink.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.tamanmandiri.orderfoodanddrink.model.DrinkModel;

import java.util.List;

@Dao
public interface DrinkDao {
    @Insert
    void insert(DrinkModel drinkModel);

    @Query("SELECT * FROM drink_table ORDER BY name ASC")
    LiveData<List<DrinkModel>> getAllDrinkModel();
}
