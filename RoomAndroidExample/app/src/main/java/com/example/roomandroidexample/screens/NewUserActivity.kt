package com.example.roomandroidexample.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.roomandroidexample.R
import com.example.roomandroidexample.persistance.UserRepository
import com.example.roomandroidexample.Users
import kotlinx.android.synthetic.main.activity_new_user.*

class NewUserActivity : AppCompatActivity() {
    var user: Users? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)

        user = intent.getParcelableExtra("user")

        user?.let {
            editText_username.setText(it.userName)
            editText_number.setText(it.number)
        } ?: kotlin.run {

        }

        val repo = UserRepository(this)

        button_save_user.setOnClickListener {
            if (Validators().validateUserInput(editText_username.text.toString(),editText_number.text.toString())) {
                kotlin.run {
                    val user = Users(
                        userName = editText_username.text.toString(),
                        number = editText_number.text.toString()
                    )
                    repo.insertUser(user)
                }
            } else {
                Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            finish()
        }
    }

}