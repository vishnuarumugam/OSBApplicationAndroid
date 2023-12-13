package com.example.osbapplication.base

import com.example.osbapplication.R
import java.text.SimpleDateFormat
import java.util.*


object ConverterObject {

    fun milliToDateConverter(milliSecs: Long?) : String{
        if(milliSecs != null){
            val sdf = SimpleDateFormat("dd-MMM-yyyy")
            val date = Date(milliSecs)
            return sdf.format(date) ?: R.string.dashed.toString()
        }
        return R.string.dashed.toString()
    }
}