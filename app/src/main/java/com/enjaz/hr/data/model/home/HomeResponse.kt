package com.enjaz.hr.data.model.home


import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("absent")
    val absent: Int,
    @SerializedName("basicSalary")
    val basicSalary: Int,
    @SerializedName("deduction")
    val deduction: Int,
    @SerializedName("delay")
    val delay: Int,
    @SerializedName("present")
    val present: Int,
    @SerializedName("teammates")
    val teammates: List<Teammate>,
    @SerializedName("totalWorkdays")
    val totalWorkdays: Int,
    @SerializedName("vacation")
    val vacation: Int,
    @SerializedName("pastMonthDiffPercentage")
    val pastMonthDiffPercentage: Int


)