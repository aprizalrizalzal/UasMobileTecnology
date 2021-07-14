package com.tamanmandiri.orderfoodanddrink.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "eat_table")
public class EatModel {

    @PrimaryKey(autoGenerate = true) private int id;
    @NonNull @ColumnInfo(name = "eat_id") private String eatId;
    @ColumnInfo(name = "avatar") private int avatar;
    @NonNull @ColumnInfo(name = "name") private String name;
    @NonNull @ColumnInfo(name = "detail") private String detail;
    @ColumnInfo(name = "price") private int price;

    public EatModel(String eatId, int avatar, @NonNull String name, @NonNull String detail, int price) {
        this.eatId = eatId;
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

    public String getEatId() {
        return eatId;
    }

    public void setEatId(@NonNull String eatId) {
        this.eatId = eatId;
    }

    @NonNull
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
