package com.example.registration_form1;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface MyDao {

    @Insert
    public void addUser(User user);

    @Query("SELECT username FROM users WHERE email = :email")
     String findUserByEmail(String email);

    @Query("SELECT password FROM users where email = :email")
    String getPassword(String email);
}
