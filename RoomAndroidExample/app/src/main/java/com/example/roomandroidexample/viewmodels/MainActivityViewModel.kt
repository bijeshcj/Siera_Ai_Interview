package com.example.roomandroidexample.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomandroidexample.Users
import com.example.roomandroidexample.persistance.UserRepository

class MainActivityViewModel constructor(private val repository: UserRepository): ViewModel() {

    val allUsersList = MutableLiveData<List<Users>>()



    fun readAllStoredUsers() {
        val allUsers = repository.getAllUsers()
        allUsersList.postValue(allUsers)
    }

}