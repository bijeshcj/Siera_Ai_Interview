package com.example.roomandroidexample.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomandroidexample.*
import com.example.roomandroidexample.persistance.UserRepository
import com.example.roomandroidexample.viewmodels.AppViewModelFactory
import com.example.roomandroidexample.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel
    lateinit var adapter: UserRecyclerAdapter
    val repo: UserRepository by lazy {
        UserRepository(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initAdapter()
        floatingActionButton.setOnClickListener {
            val intent = Intent(this@MainActivity, NewUserActivity::class.java)
            startActivity(intent)
        }

    }

    val obs = Observer<List<Users>>{
        adapter.setUsers(it)
    }
    fun initViewModel(){
        viewModel = ViewModelProvider(this, AppViewModelFactory(UserRepository(this))).get(MainActivityViewModel::class.java)
        viewModel.allUsersList.observe(this,obs)
    }
    fun initAdapter(){
        adapter = UserRecyclerAdapter()
        recyclerview_users.layoutManager = LinearLayoutManager(this)
        recyclerview_users.adapter = adapter
    }
    override fun onResume() {
        super.onResume()
        viewModel.readAllStoredUsers()
    }

}
