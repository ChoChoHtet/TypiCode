package com.android.typicode.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.typicode.databinding.ItemUserViewBinding
import com.android.typicode.entity.Users
import com.android.typicode.ui.adapter.UserAdapter

class UserViewHolder(
    private val binding: ItemUserViewBinding,
    private val clickListener: UserAdapter.ItemClickListener
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(user: Users) {
        binding.apply {
            this.tvUsername.text = user.name
            this.tvEmail.text = user.email
            root.setOnClickListener {
                clickListener.onItemClicked(user)
            }
        }

    }
}