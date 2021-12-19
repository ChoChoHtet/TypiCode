package com.android.typicode.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.android.typicode.entity.Users

class UserDiffUtils : DiffUtil.ItemCallback<Users>() {
    override fun areItemsTheSame(oldItem: Users, newItem: Users): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Users, newItem: Users): Boolean {
        return oldItem == newItem
    }
}