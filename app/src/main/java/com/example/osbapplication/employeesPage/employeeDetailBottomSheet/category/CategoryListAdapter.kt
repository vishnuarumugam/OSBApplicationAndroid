package com.example.osbapplication.employeesPage.employeeDetailBottomSheet.category

import android.content.Context
import android.util.Log
import com.example.osbapplication.R
import com.example.osbapplication.base.RecyclerBaseAdapter
import com.example.osbapplication.base.RecyclerViewHolder
import com.example.osbapplication.databinding.LayCategoryRowBinding

class CategoryListAdapter(private val context: Context, private var items: MutableList<String>) : RecyclerBaseAdapter() {

    private var layCategoryRowBinding: LayCategoryRowBinding? = null
    private var categoryAdapterVM: CategoryAdapterVM? = null

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.lay_category_row
    }

    override fun getViewModel(holder: RecyclerViewHolder, position: Int): Any? {
        return if (holder.binding is LayCategoryRowBinding) {
            layCategoryRowBinding = holder.binding as LayCategoryRowBinding
            Log.w("getViewModelsetData", "::" + items)
            categoryAdapterVM = CategoryAdapterVM(context, items[position])
            (layCategoryRowBinding as LayCategoryRowBinding).viewModel = categoryAdapterVM
            categoryAdapterVM
        } else null
    }

    override fun getItemCount() = items.size

    fun setData(_items: List<String>?) {
        Log.w("setData", ":CategoryData:" + _items)
        items.clear()
        if (!_items.isNullOrEmpty())
            items.addAll(_items)
        notifyDataSetChanged()
    }
}