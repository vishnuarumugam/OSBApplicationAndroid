package com.example.osbapplication.employeesPage.employeeDetailBottomSheet

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.osbapplication.R
import com.example.osbapplication.databinding.FragmentEmployeeDetailBinding
import com.example.osbapplication.employeesPage.employeeDetailBottomSheet.category.CategoryListAdapter
import com.example.osbapplication.employeesPage.employees.EmployeesListAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.greenrobot.eventbus.EventBus
import java.lang.ref.WeakReference


class EmployeeDetailFragment : BottomSheetDialogFragment() {

    lateinit var fragmentEmployeeDetailBinding: FragmentEmployeeDetailBinding

    private val employeeDetailViewModel : EmployeeDetailViewModel by viewModels {
        EmployeeDetailVMFactory(WeakReference(context))
    }

    private val categoryListAdapter by lazy {
        CategoryListAdapter(requireContext(), arrayListOf())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            Log.w("bottomSheet", "::")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentEmployeeDetailBinding = FragmentEmployeeDetailBinding.inflate(inflater, container, false)
        fragmentEmployeeDetailBinding.viewModel = employeeDetailViewModel
        employeeDetailViewModel.init(requireContext())
        return fragmentEmployeeDetailBinding.root
    }

    override fun onResume() {
        super.onResume()
        loadUI()
    }

//    override fun onStart() {
//        super.onStart()
//        EventBus.getDefault().register(this)
//    }
//
//    override fun onStop() {
//        super.onStop()
//        EventBus.getDefault().unregister(this)
//    }

    fun loadUI(){
        makeAPICall()
        setAdapter()
        observers()
    }

    private fun makeAPICall() {
        Log.w("makeAPICall", "::")
    }


    private fun observers() {
        Log.w("observers", "::")
        employeeDetailViewModel.categoryAdapterVM.observe(this, Observer{
            categoryListAdapter.setData(it)
        })
    }

    private fun setAdapter() {
        Log.w("setAdapter", "::")
        fragmentEmployeeDetailBinding.rvCategorySearch.setLayoutManager(
            LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
        )
        fragmentEmployeeDetailBinding.rvCategorySearch.adapter = categoryListAdapter
    }


}