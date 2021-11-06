package com.nprmanbrandons11.datepicker
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nprmanbrandons11.datepicker.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity(){

    lateinit var binding: ActivityMainBinding
    private var pickedDate :Boolean = false
    private var dia:Int = 0
    private var mes:Int = 0
    private var año:Int = 0
    private val mayoria_de_Edad = 6570

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textViewFecha.setOnClickListener{
            showDatePickerDialog()
        }
        binding.buttonContinue.setOnClickListener {
            if(pickedDate){
                val cal1 = GregorianCalendar()
                val cal2 = GregorianCalendar()
                cal1.set(año,mes,dia)
                cal2.set(Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH)
                val diference :Int = (cal2.timeInMillis.toInt() - cal1.timeInMillis.toInt()) *(1000*60*60*24)
                if(diference > mayoria_de_Edad) {
                    Toast.makeText(this, "${diference} Eres Mayor de Edad", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "${diference} Eres menor de Edad", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this,"No se ha seleccionado una Fecha de cumpleaños",Toast.LENGTH_SHORT).show()
            }
        }

    }
    private fun showDatePickerDialog() {
            val newFragment = DatePicker_fragment{day,month,year -> onDateSelected(day,month,year)}
            newFragment.show(supportFragmentManager, "datePicker")
        }
    private fun onDateSelected(day: Int, month: Int, year: Int){
        binding.textViewFecha.text ="$day / $month / $year"
        pickedDate = true
        dia = day
        mes = month
        año = year
    }
    }