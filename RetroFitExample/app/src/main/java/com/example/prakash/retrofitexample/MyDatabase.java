package com.example.prakash.retrofitexample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;


@Database(entities = {Heromodel.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {

    public abstract MyDao myDao();



}
