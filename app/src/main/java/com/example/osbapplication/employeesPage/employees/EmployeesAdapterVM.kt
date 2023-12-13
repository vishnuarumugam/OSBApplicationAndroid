package com.example.osbapplication.employeesPage.employees

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.osbapplication.R
import com.example.osbapplication.base.ConverterObject.milliToDateConverter
import com.example.osbapplication.model.dataModel.Employee

class EmployeesAdapterVM(val context: Context, var employee: Employee): ViewModel()  {

    fun getName() = employee.name ?: context.getString(R.string.dashed)

    fun getWorkDate() : String {
        return context.getString(R.string.working_from) +" "+ milliToDateConverter(employee.dateOfJoining)
    }

    fun getSalary() : String {
        return employee.salary.toString() +" "+ context.getString(R.string.per_day)
    }

    fun getCategory() = employee.category ?: context.getString(R.string.dashed)
}
