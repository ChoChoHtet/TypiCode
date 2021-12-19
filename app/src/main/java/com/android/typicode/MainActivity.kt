package com.android.typicode

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.lottie.LottieDrawable
import com.android.typicode.databinding.ActivityMainBinding
import com.android.typicode.di.ViewModelFactory
import com.android.typicode.entity.Users
import com.android.typicode.ui.adapter.UserAdapter
import com.android.typicode.utils.Result
import com.android.typicode.view.UserDetailActivity
import com.android.typicode.viewmodel.UserViewModel
import com.google.gson.Gson
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), UserAdapter.ItemClickListener {
    companion object {
        const val USER_EXTRAS = "USER_EXTRAS"
    }

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var viewModel: UserViewModel
    private var userAdapter: UserAdapter? = null


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        viewModel = ViewModelProvider(this, viewModelFactory)[UserViewModel::class.java]
        observerResponse()
        initAdapter()
        viewModel.getAllUsers()
    }

    private fun initAdapter() {
        userAdapter = UserAdapter(this)
        activityMainBinding.rvUserList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }

    private fun observerResponse() {
        viewModel.observeAllUsers.observe(this, { result ->
            when (result) {
                is Result.Loading -> {
                    Log.d("testing__", "loading..")
                    activityMainBinding.apply {
                        rvUserList.visibility = View.GONE
                        errorView.visibility = View.VISIBLE
                        errorView.setAnimation("loading.json")
                        errorView.playAnimation()

                    }
                }
                is Result.Success -> {
                    Log.d("testing__", "${result.value?.size}")
                    activityMainBinding.apply {
                        rvUserList.visibility = View.VISIBLE
                        errorView.visibility = View.GONE
                    }
                    if (!result.value.isNullOrEmpty()){
                        userAdapter?.submitList(result.value)
                    }

                }
                else -> {
                    Log.d("testing__", "error:${result.message.orEmpty()}")
                    activityMainBinding.apply {
                        rvUserList.visibility = View.GONE
                        errorView.visibility = View.VISIBLE
                        errorView.setAnimation("network_error.json")
                        errorView.repeatCount =LottieDrawable.INFINITE
                        errorView.playAnimation()

                    }
                }
            }

        })

    }

    override fun onItemClicked(user: Users) {
        val intent = Intent(this, UserDetailActivity::class.java)
        Log.d("testing__", "users:=== ${Gson().toJson(user)}")
        intent.putExtra(USER_EXTRAS, user)
        this.startActivity(intent)
    }
}