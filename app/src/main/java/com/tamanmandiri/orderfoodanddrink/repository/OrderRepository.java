package com.tamanmandiri.orderfoodanddrink.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.tamanmandiri.orderfoodanddrink.dao.OrderDao;
import com.tamanmandiri.orderfoodanddrink.data.OrderRoomDatabase;
import com.tamanmandiri.orderfoodanddrink.model.OrderModel;

import java.util.List;

public class OrderRepository {
    private final OrderDao orderDao;
    private final LiveData<List<OrderModel>> allOrder;

    public OrderRepository(Application application){
        OrderRoomDatabase db = OrderRoomDatabase.getDatabaseOrder(application);
        orderDao = db.orderDao();
        allOrder = orderDao.getAllOrderModel();
    }

    public void insert (OrderModel orderModel){
        OrderRoomDatabase.databaseWriteExecutor.execute(() -> orderDao.insert(orderModel));
    }

    public void updateAmount(int orderAmount, int id){
        OrderRoomDatabase.databaseWriteExecutor.execute(() -> orderDao.updateAmount(orderAmount, id));
    }

    /*public void totalAmount(int totalAmount){
        OrderRoomDatabase.databaseWriteExecutor.execute(() -> orderDao.totalAmount(totalAmount));
    }*/

    public void delete (OrderModel orderModel){
        OrderRoomDatabase.databaseWriteExecutor.execute(() -> orderDao.delete(orderModel));
    }

    public void deleteAllOrder() {
        OrderRoomDatabase.databaseWriteExecutor.execute(orderDao::deleteAll);
    }

    public LiveData<List<OrderModel>> getAllOrder() {
        return allOrder;
    }
}
