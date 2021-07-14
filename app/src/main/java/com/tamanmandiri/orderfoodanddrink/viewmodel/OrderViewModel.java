package com.tamanmandiri.orderfoodanddrink.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.tamanmandiri.orderfoodanddrink.model.OrderModel;
import com.tamanmandiri.orderfoodanddrink.repository.OrderRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OrderViewModel extends AndroidViewModel {
    private final OrderRepository repository;
    private final LiveData<List<OrderModel>> allOrder;

    public OrderViewModel(@NonNull @NotNull Application application){
        super(application);
        repository = new OrderRepository(application);
        allOrder = repository.getAllOrder();
    }

    public void insert (OrderModel orderModel){
        repository.insert(orderModel);
    }

    public void updateAmount (int orderAmount, int id){
        repository.updateAmount(orderAmount, id);
    }

    /*public void totalAmount (int totalAmount){
        repository.totalAmount(totalAmount);
    }*/

    public void delete (OrderModel orderModel){
        repository.delete(orderModel);
    }

    public void deleteAllOrder() {
        repository.deleteAllOrder();
    }

    public LiveData<List<OrderModel>> getAllOrder(){
        return allOrder;
    }
}
