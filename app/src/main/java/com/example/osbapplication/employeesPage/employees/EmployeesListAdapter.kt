package com.example.osbapplication.employeesPage.employees

import android.content.Context
import android.util.Log
import com.example.osbapplication.R
import com.example.osbapplication.base.RecyclerBaseAdapter
import com.example.osbapplication.base.RecyclerViewHolder
import com.example.osbapplication.databinding.LayEmployeeRowBinding
import com.example.osbapplication.model.dataModel.Employee

class EmployeesListAdapter(private val context: Context, private var items: MutableList<Employee>) : RecyclerBaseAdapter() {

    private var layEmployeeRowBinding: LayEmployeeRowBinding? = null
    private var employeesAdapterVM: EmployeesAdapterVM? = null

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.lay_employee_row
    }

    override fun getViewModel(holder: RecyclerViewHolder, position: Int): Any? {
        return if (holder.binding is LayEmployeeRowBinding) {
            layEmployeeRowBinding = holder.binding as LayEmployeeRowBinding
            Log.w("getViewModelsetData", "::" + items[position])
            employeesAdapterVM = EmployeesAdapterVM(context, items[position])
            (layEmployeeRowBinding as LayEmployeeRowBinding).viewModel = employeesAdapterVM
            employeesAdapterVM
        } else null
    }

    override fun getItemCount() = items.size

    fun setData(_items: List<Employee>?) {
        Log.w("setData", ":EmployeeData:" + _items)
        items.clear()
        if (!_items.isNullOrEmpty())
            items.addAll(_items)
        notifyDataSetChanged()
    }
}