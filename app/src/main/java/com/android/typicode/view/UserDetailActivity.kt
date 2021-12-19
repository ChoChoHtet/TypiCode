package com.android.typicode.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.android.typicode.MainActivity.Companion.USER_EXTRAS
import com.android.typicode.R
import com.android.typicode.databinding.ActivityUserDetailBinding
import com.android.typicode.entity.Users
import com.google.gson.Gson
import dagger.android.support.DaggerAppCompatActivity

class UserDetailActivity : DaggerAppCompatActivity() {
    private lateinit var activityUserDetailBinding: ActivityUserDetailBinding
    private val getUserExtra: Users?
        get() = intent?.extras?.getSerializable(USER_EXTRAS) as Users?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityUserDetailBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_user_detail
        )
        if (getUserExtra != null) {
            activityUserDetailBinding.apply {
                this.tvName.text = getUserExtra!!.name
                this.tvEmail.text = getUserExtra!!.email
                this.tvPhone.text = getUserExtra!!.phone
              //  this.tvAddressCity.text = getUserExtra!!.address.city
                this.tvAddressStreet.text = getString(
                    R.string.user_address,
                    getUserExtra?.address?.street,
                    getUserExtra?.address?.city
                )
                this.tvAddressSuite.text =
                    getString(R.string.user_suite, getUserExtra!!.address.suite)
                this.tvWebsite.text = getUserExtra!!.website
                this.tvWebsite.movementMethod = LinkMovementMethod.getInstance()
                this.tvWebsite.setTextColor(Color.BLUE)
            }
        }
    }
}