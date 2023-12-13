package com.example.osbapplication.homePage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.osbapplication.R
import com.example.osbapplication.databinding.ActivityHomePageBinding
import com.example.osbapplication.employeesPage.EmployeesPageActivity
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.lang.ref.WeakReference

class HomePageActivity : AppCompatActivity() {

    lateinit var homePageBinding: ActivityHomePageBinding

    enum class ViewOnClick{
        EMPLOYEES
    }

    private val homePageViewModel : HomePageViewModel by viewModels {
        HomePageVMFactory(WeakReference(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homePageBinding = DataBindingUtil.setContentView(this, R.layout.activity_home_page)
        homePageBinding.viewModel = homePageViewModel
        homePageViewModel.init(this)
        homePageBinding.executePendingBindings()
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

            ViewOnClick.EMPLOYEES->{
                Log.w("EMPLOYEES", "::")
                startActivity(Intent(this, EmployeesPageActivity::class.java))
            }
            else -> {}
        }
    }
}