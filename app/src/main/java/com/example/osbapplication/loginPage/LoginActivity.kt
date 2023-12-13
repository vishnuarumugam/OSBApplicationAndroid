package com.example.osbapplication.loginPage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.osbapplication.R
import com.example.osbapplication.databinding.ActivityLoginBinding
import com.example.osbapplication.homePage.HomePageActivity
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.lang.ref.WeakReference

class LoginActivity : AppCompatActivity() {

    lateinit var activityLoginBinding: ActivityLoginBinding

    enum class ViewOnClick{
        LOGIN
    }

    private val loginViewModel : LoginViewModel by viewModels {
        LoginVMFactory(WeakReference(this))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        activityLoginBinding.viewModel = loginViewModel
        loginViewModel.init(this)
        activityLoginBinding.executePendingBindings()
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(btnClick: ViewOnClick) {

        when (btnClick) {

            ViewOnClick.LOGIN->{
                Log.w("LOGIN", "::")
                startActivity(Intent(this, HomePageActivity::class.java))
            }
            else -> {}
        }
    }


}