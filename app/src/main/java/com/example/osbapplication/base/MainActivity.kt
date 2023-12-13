package com.example.osbapplication.base

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.osbapplication.R
import com.example.osbapplication.loginPage.LoginActivity

class MainActivity : AppCompatActivity() {

    val sharedPrefRepo = SharedPrefRepo.getInstance()
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.my_nav_host_fragment)
    }

    override fun onResume() {
        super.onResume()
        loadUI()
    }

    private fun loadUI() {
        val isLoggedIn = sharedPrefRepo?.getBoolean(Constants.LOGGED_IN) ?: false

        if (isLoggedIn){
            Log.w("LoggedIn","::")
        }else{
            Log.w("Not Logged In","::")
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }


}