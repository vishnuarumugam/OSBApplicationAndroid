package com.example.osbapplication.homePage

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import org.greenrobot.eventbus.EventBus
import java.lang.ref.WeakReference

class HomePageViewModel(private val weakContext: WeakReference<Context?>) : ViewModel()  {

    private var mActivity: Context? = null

    fun init(context: Context) {
        mActivity = context
    }

    fun onEmployees(view: View){
        Log.w("onEmployees", "::")
        EventBus.getDefault().post(HomePageActivity.ViewOnClick.EMPLOYEES)
    }
}