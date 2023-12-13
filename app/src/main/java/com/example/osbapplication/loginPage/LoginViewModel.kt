package com.example.osbapplication.loginPage

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import org.greenrobot.eventbus.EventBus
import java.lang.ref.WeakReference

class LoginViewModel(private val weakContext: WeakReference<Context?>) : ViewModel()  {

    private var mActivity: Context? = null

    fun init(context: Context) {
        mActivity = context
    }

    fun onLogin(view:View){
        Log.w("onLogin", "::")
        EventBus.getDefault().post(LoginActivity.ViewOnClick.LOGIN)
    }
}