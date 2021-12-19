package com.android.typicode.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.android.typicode.R
import com.android.typicode.databinding.ItemUserViewBinding
import com.android.typicode.entity.Users
import com.android.typicode.ui.viewholder.UserViewHolder

class UserAdapter(private val clickListener: ItemClickListener) :
    ListAdapter<Users, UserViewHolder>(UserDiffUtils()) {
    interface ItemClickListener {
        fun onItemClicked(user: Users)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val userBinding = DataBindingUtil.inflate<ItemUserViewBinding>(
            LayoutInflater.from(parent.context), R.layout.item_user_view, parent, false
        )
        return UserViewHolder(binding = userBinding, clickListener)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}