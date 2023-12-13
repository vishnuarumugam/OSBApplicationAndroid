package com.example.osbapplication.employeesPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.osbapplication.R
import com.example.osbapplication.base.Constants
import com.example.osbapplication.databinding.ActivityEmployeesPageBinding
import com.example.osbapplication.employeesPage.employeeDetailBottomSheet.EmployeeDetailFragment
import com.example.osbapplication.employeesPage.employees.EmployeesListAdapter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.lang.ref.WeakReference

class EmployeesPageActivity : AppCompatActivity() {

    lateinit var employeesPageBinding: ActivityEmployeesPageBinding
    private lateinit var employeeDetailFragment: EmployeeDetailFragment

    enum class ViewOnClick{
        ADD_EMPLOYEE
    }

    private val employeesPageViewModel : EmployeesPageViewModel by viewModels {
        EmployeesPageVMFactory(WeakReference(this))
    }

    private val employeesListAdapter by lazy {
        EmployeesListAdapter(applicationContext, arrayListOf())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        employeesPageBinding = DataBindingUtil.setContentView(this, R.layout.activity_employees_page)
        employeesPageBinding.viewModel = employeesPageViewModel
        employeesPageViewModel.init(this)
        employeesPageBinding.executePendingBindings()
    }

    override fun onResume() {
        super.onResume()
        loadUI()
    }
    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    fun loadUI(){
        makeAPICall()
        setAdapter()
        observers()
    }

    private fun makeAPICall() {
        Log.w("makeAPICall", "::")
        employeesPageViewModel.getEmployees()
    }
    private fun observers() {
        Log.w("observers", "::")
        employeesPageViewModel.employeesAdapterVM.observe(this, Observer{
            employeesListAdapter.setData(it)
        })
    }

    private fun setAdapter() {
        Log.w("setAdapter", "::")
        employeesPageBinding.rvEmployees.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )
        )
        employeesPageBinding.rvEmployees.adapter = employeesListAdapter
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(btnClick: ViewOnClick) {

        when (btnClick) {

            ViewOnClick.ADD_EMPLOYEE->{
                Log.w("ADD_EMPLOYEE", "::")
                employeeDetailFragment = EmployeeDetailFragment()
                employeeDetailFragment.show(supportFragmentManager, Constants.BOTTOM_SHEET)
            }
            else -> {}
        }
    }
}