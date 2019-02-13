package com.example.prakash.retrofitexample;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Query("select * from users where name= :name")
    public Heromodel userbyName(String name);

    @Query("select * from users")
    public List<Heromodel> getUsers();

    @Delete
    public void deleteUser(Heromodel user);


    @Query("Update users SET name =:updatedName where name =:name")
    public int updateUser(String name, String updatedName);

    @Query("Delete FROM users where name= :name")
    public int deleteUserbyname(String name);

    @Insert
    void addusers(List<Heromodel> heroList);
}
