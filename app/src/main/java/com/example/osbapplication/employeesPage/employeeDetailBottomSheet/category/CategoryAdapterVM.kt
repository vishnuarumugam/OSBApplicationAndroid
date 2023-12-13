package com.example.osbapplication.employeesPage.employeeDetailBottomSheet.category

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel

class CategoryAdapterVM(val context: Context, var category: String): ViewModel()  {

    fun getCategoryName() = category

    fun onCategorySelected(view: View){

    }
}