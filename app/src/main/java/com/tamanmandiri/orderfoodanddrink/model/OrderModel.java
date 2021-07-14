package com.tamanmandiri.orderfoodanddrink.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "order_table")
public class OrderModel {

    @PrimaryKey(autoGenerate = true) private int id;
    @NonNull @ColumnInfo(name = "order_id") private String orderId;
    @ColumnInfo(name = "avatar") private int avatar;
    @NonNull @ColumnInfo(name = "name") private String name;
    @ColumnInfo(name = "price") private int price;
    @ColumnInfo(name = "amount") private int amount;
    /*@ColumnInfo(name = "total") private int total;*/

    public OrderModel(@NonNull String orderId, int avatar, @NonNull String name, int price, int amount) {
        this.orderId = orderId;
        this.avatar = avatar;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(@NonNull String orderId) {
        this.orderId = orderId;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    /*public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }*/
}
