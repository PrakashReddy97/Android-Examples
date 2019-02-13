package com.example.prakash.registrationform;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void adduser(User user);

    @Query("select * from users")
    public List<User> getUsers();
}
