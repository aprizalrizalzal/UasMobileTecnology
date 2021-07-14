package com.tamanmandiri.orderfoodanddrink.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.tamanmandiri.orderfoodanddrink.dao.DrinkDao;
import com.tamanmandiri.orderfoodanddrink.data.DrinkRoomDatabase;
import com.tamanmandiri.orderfoodanddrink.model.DrinkModel;

import java.util.List;

public class DrinkRepository {
    private final DrinkDao drinkDao;
    private final LiveData<List<DrinkModel>> allDrink;

    public DrinkRepository(Application application){
        DrinkRoomDatabase db = DrinkRoomDatabase.getDatabaseDrink(application);
        drinkDao = db.drinkDao();
        allDrink = drinkDao.getAllDrinkModel();
    }

    public void insert(DrinkModel drinkModel){
        DrinkRoomDatabase.databaseWriteExecutor.execute(() -> drinkDao.insert(drinkModel));
    }

    public LiveData<List<DrinkModel>> getAllDrink(){
        return allDrink;
    }

}
