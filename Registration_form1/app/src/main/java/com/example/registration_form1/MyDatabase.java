package com.example.registration_form1;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.RoomDatabase;


@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {

    public abstract MyDao myDao();

}
