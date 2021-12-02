package com.example.roomandroidexample.persistance

import androidx.room.*
import com.example.roomandroidexample.Users

@Dao
interface UserDao {
    @Insert
    fun insertUser(users: Users)

    @Query("Select * from user")
    fun gelAllUsers(): List<Users>

}