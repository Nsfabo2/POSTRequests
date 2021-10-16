package com.example.postrequests

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.postrequests.databinding.*
import kotlinx.android.synthetic.main.activity_new_user.view.*

class UsersRecyclerViewAdapter (private val UsersList: ArrayList<UserItem>): RecyclerView.Adapter<UsersRecyclerViewAdapter.UserViewHolder>(){
    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val button: Button = itemView.Submitbtn
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.user_item_row,
            parent,
            false
        )
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentTitle = UsersList[position]
        val currentLink = UsersList[position]
        //holder.button.text =

    }

    override fun getItemCount() = UsersList.size
}