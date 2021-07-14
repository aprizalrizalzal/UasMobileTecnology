package com.tamanmandiri.orderfoodanddrink.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.tamanmandiri.orderfoodanddrink.model.EatModel;
import com.tamanmandiri.orderfoodanddrink.repository.EatRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EatViewModel extends AndroidViewModel {

    private final EatRepository repository;
    private final LiveData<List<EatModel>> allEat;

    public EatViewModel(@NonNull @NotNull Application application) {
        super(application);
        repository = new EatRepository(application);
        allEat = repository.getAllEat();
    }

    public void insert(EatModel eatModel) {
        repository.insert(eatModel);
    }

    public LiveData<List<EatModel>> getAllEat() {
        return allEat;
    }
}
