package com.nprmanbrandons11.datepicker

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*


class DatePicker_fragment(val listener :(day: Int,month:Int,year:Int)->Unit) : DialogFragment(), DatePickerDialog.OnDateSetListener{

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
       val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dp = DatePickerDialog(activity as Context,R.style.MySpinnerDatePickerStyle,this, year, month, day)
        dp.datePicker.maxDate = c.timeInMillis

        return dp
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        listener(day,month,year)
    }


}