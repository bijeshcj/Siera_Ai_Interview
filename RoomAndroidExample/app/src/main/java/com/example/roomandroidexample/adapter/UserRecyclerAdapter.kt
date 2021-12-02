package com.example.roomandroidexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_user_list.view.*

class UserRecyclerAdapter : RecyclerView.Adapter<UserViewHolder>() {

    var userList = mutableListOf<Users>()
    fun setUsers(users: List<Users>) {
        this.userList = users.toMutableList()
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_user_list, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.username.text = user.userName
        holder.number.text = user.number
    }
}

class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val username = view.textViewUsername
    val number = view.textViewNumber

}


