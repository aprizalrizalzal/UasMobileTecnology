package com.tamanmandiri.orderfoodanddrink.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "drink_table")
public class DrinkModel {

    @PrimaryKey(autoGenerate = true) private int id;
    @NonNull @ColumnInfo(name = "drink_id") private String drinkId;
    @ColumnInfo(name = "avatar") private int avatar;
    @NonNull @ColumnInfo(name = "name") private String name;
    @NonNull @ColumnInfo(name = "detail") private String detail;
    @ColumnInfo(name = "price") private int price;

    public DrinkModel(@NonNull String drinkId, int avatar, @NonNull String name, @NonNull String detail, int price) {
        this.drinkId = drinkId;
        this.avatar = avatar;
        this.name = name;
        this.detail = detail;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(@NonNull String drinkId) {
        this.drinkId = drinkId;
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

    @NonNull
    public String getDetail() {
        return detail;
    }

    public void setDetail(@NonNull String detail) {
        this.detail = detail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
