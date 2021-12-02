package com.example.roomandroidexample.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomandroidexample.persistance.UserRepository
import java.lang.IllegalArgumentException

class AppViewModelFactory constructor(private val repository: UserRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)){
            MainActivityViewModel(this.repository) as T
        }else{
            throw IllegalArgumentException("ViewModel not found")
        }
    }

}