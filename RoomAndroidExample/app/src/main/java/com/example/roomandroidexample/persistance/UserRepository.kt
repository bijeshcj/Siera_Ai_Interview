package com.example.roomandroidexample.persistance

import android.content.Context
import com.example.roomandroidexample.Users
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class UserRepository(context: Context) {

    var db: UserDao = AppDatabase.getInstance(context)?.userDao()!!

    fun getAllUsers(): List<Users> {
        return db.gelAllUsers()
    }
    fun insertUser(users: Users) {
        insert(users, db)
    }
    private fun insert(user: Users,usersDao: UserDao){
      GlobalScope.launch(Dispatchers.IO){
          usersDao.insertUser(user)
      }
    }

}