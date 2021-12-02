package com.example.roomandroidexample.screens

public class Validators {

    fun validateUserInput(userName: String, number: String): Boolean {
        return userName.isNotEmpty() && number.isNotEmpty()
    }

}