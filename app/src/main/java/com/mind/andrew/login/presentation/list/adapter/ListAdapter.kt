package com.mind.andrew.login.presentation.list.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mind.andrew.login.R
import com.mind.andrew.login.domain.model.UserModel
import kotlinx.android.synthetic.main.item_user.view.*

class ListAdapter(var list: List<UserModel>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ListViewHolder(v)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ListViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        fun bindItem(holder: UserModel) {
            itemView.login_text.text = holder.login
            itemView.pass_text.text = holder.password

            Log.e("tag", "login: ${holder.login}")
            Log.e("tag", "password: ${holder.password}")
//            itemView.circle_text.text = holder.login?.toCharArray()[0].toString()?:"A"
        }
    }
}