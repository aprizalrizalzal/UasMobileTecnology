package com.tamanmandiri.orderfoodanddrink.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.tamanmandiri.orderfoodanddrink.model.DrinkModel;
import com.tamanmandiri.orderfoodanddrink.repository.DrinkRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DrinkViewModel extends AndroidViewModel {

    private final DrinkRepository repository;
    private final LiveData<List<DrinkModel>> allDrink;

    public DrinkViewModel(@NonNull @NotNull Application application) {
        super(application);
        repository = new DrinkRepository(application);
        allDrink = repository.getAllDrink();
    }

    public void insert(DrinkModel drinkModel) {
        repository.insert(drinkModel);
    }

    public LiveData<List<DrinkModel>> getAllDrink() {
        return allDrink;
    }

}
