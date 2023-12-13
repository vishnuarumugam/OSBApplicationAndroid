package com.example.osbapplication.employeesPage.employeeDetailBottomSheet

import android.content.Context
import android.util.Log
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.osbapplication.R
import com.example.osbapplication.base.Constants
import com.example.osbapplication.model.dataModel.Employee
import java.lang.ref.WeakReference

class EmployeeDetailViewModel(private val weakContext: WeakReference<Context?>) : ViewModel()  {

    private var mActivity: Context? = null
    var categoryAdapterVM = MutableLiveData<MutableList<String>>()
    var categoryListVisible = ObservableBoolean(false)

    fun init(context: Context) {
        mActivity = context
    }

    fun onCategorySelected(view: View){
        Log.w("onCategorySelected", "::")
        val categoryList = mActivity?.resources?.getStringArray(R.array.categoryArray)
        Log.w("categoryList", "::" + categoryList)
        categoryAdapterVM.postValue(categoryList?.toMutableList() ?: mutableListOf())
        categoryListVisible.set(!categoryListVisible.get())
    }
}