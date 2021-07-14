package com.tamanmandiri.orderfoodanddrink.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.tamanmandiri.orderfoodanddrink.dao.OrderDao;
import com.tamanmandiri.orderfoodanddrink.model.OrderModel;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {OrderModel.class}, version = 1)
public abstract class OrderRoomDatabase extends RoomDatabase {
    public abstract OrderDao orderDao();

    public static volatile OrderRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized OrderRoomDatabase getDatabaseOrder(final Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    OrderRoomDatabase.class, "order_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();
        }
        return INSTANCE;
    }
    private static final RoomDatabase.Callback callback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull @NotNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };
}
