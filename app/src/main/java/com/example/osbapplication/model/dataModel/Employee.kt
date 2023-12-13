package com.example.osbapplication.model.dataModel

import com.google.gson.annotations.SerializedName

data class Employee(
    @SerializedName("employeeCategory") var category: String? = null,
    @SerializedName("employeeName") var name: String? = null,
    @SerializedName("employeeSalary") var salary: Int? = null,
    @SerializedName("dateOfJoining") var dateOfJoining: Long? = null,
    @SerializedName("gender") var gender: Int? = null,
)
