package com.tamanmandiri.orderfoodanddrink.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.tamanmandiri.orderfoodanddrink.model.OrderModel;
import java.util.List;

@Dao
public interface

OrderDao {
    @Insert
    void insert(OrderModel orderModel);

    @Query("UPDATE order_table SET amount = :amount WHERE id = :id")
    void updateAmount(int amount, int id);

    @Delete
    void delete(OrderModel orderModel);

    @Query("DELETE FROM order_table")
    void deleteAll();

    @Query("SELECT * FROM order_table ORDER BY name ASC")
    LiveData<List<OrderModel>> getAllOrderModel();

}
