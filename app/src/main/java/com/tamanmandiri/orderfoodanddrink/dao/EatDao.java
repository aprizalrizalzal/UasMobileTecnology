package com.tamanmandiri.orderfoodanddrink.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.tamanmandiri.orderfoodanddrink.model.EatModel;

import java.util.List;

@Dao
public interface EatDao {
    @Insert
    void insert(EatModel eatModel);

    @Query("SELECT * FROM eat_table ORDER BY name ASC")
    LiveData<List<EatModel>> getAllEatModel();
}
