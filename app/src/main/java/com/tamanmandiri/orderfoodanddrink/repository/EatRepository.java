package com.tamanmandiri.orderfoodanddrink.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.tamanmandiri.orderfoodanddrink.dao.EatDao;
import com.tamanmandiri.orderfoodanddrink.data.EatRoomDatabase;
import com.tamanmandiri.orderfoodanddrink.model.EatModel;

import java.util.List;

public class EatRepository {
    private final EatDao eatDao;
    private final LiveData<List<EatModel>> allEat;

    public EatRepository(Application application) {
        EatRoomDatabase db = EatRoomDatabase.getDatabaseEat(application);
        eatDao = db.eatDao();
        allEat = eatDao.getAllEatModel();
    }

    public void insert(EatModel eatModel){
        EatRoomDatabase.databaseWriteExecutor.execute(() -> eatDao.insert(eatModel));
    }

    public LiveData<List<EatModel>> getAllEat() {
        return allEat;
    }
}