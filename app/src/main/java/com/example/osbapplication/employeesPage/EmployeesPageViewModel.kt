package com.example.osbapplication.employeesPage

import android.content.Context
import android.media.metrics.Event
import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.osbapplication.R
import com.example.osbapplication.base.Constants
import com.example.osbapplication.model.dataModel.Employee
import org.greenrobot.eventbus.EventBus
import java.lang.ref.WeakReference

class EmployeesPageViewModel(private val weakContext: WeakReference<Context?>) : ViewModel()  {

    private var mActivity: Context? = null
    var employeesAdapterVM = MutableLiveData<MutableList<Employee>>()
    var maleEmployeeCount = ObservableField("")
    var femaleEmployeeCount = ObservableField("")
    var totalEmployeeCount = ObservableField("")

    fun init(context: Context) {
        mActivity = context
        maleEmployeeCount.set(context.getString(R.string.dashed))
        femaleEmployeeCount.set(context.getString(R.string.dashed))
        totalEmployeeCount.set(context.getString(R.string.dashed))
    }

    fun addEmployee(view:View){
        Log.w("addEmployee", "::")
        EventBus.getDefault().post(EmployeesPageActivity.ViewOnClick.ADD_EMPLOYEE)
    }

    fun getEmployees(){
        Log.w("addEmployee", "::")

        val employeeList = arrayListOf <Employee>()
        employeeList.add(Employee("Waiter", "Mani", 250, 1448889376000, 0))
        employeeList.add(Employee("Waiter", "Mani(CBR)", 400, 1448889376000, 0))
        employeeList.add(Employee("Cleaner", "Sundar", 250, 1448889376000, 0))
        employeeList.add(Employee("Waiter", "Shanthi", 400, 1448889376000, 1))

        val mCount = employeeList.filter { it -> it.gender == Constants.Gender.MALE }
        val fCount = employeeList.filter { it -> it.gender == Constants.Gender.FEMALE }


        maleEmployeeCount.set(mCount.size.toString())
        femaleEmployeeCount.set(fCount.size.toString())
        totalEmployeeCount.set((mCount.size + fCount.size).toString())

        employeesAdapterVM.postValue(employeeList)
    }

}