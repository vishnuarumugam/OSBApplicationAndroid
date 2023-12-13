package com.example.osbapplication.employeesPage.employeeDetailBottomSheet

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.ref.WeakReference

class EmployeeDetailVMFactory(private val weakContext: WeakReference<Context?>) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EmployeeDetailViewModel(weakContext) as T
    }
}