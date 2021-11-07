package com.nprmanbrandons11.datepicker
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nprmanbrandons11.datepicker.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Calendar


class MainActivity : AppCompatActivity(){

    lateinit var binding: ActivityMainBinding
    private var pickedDate :Boolean = false
    private var dia:Int = 0
    private var mes:Int = 0
    private var año:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textViewFecha.setOnClickListener{
            showDatePickerDialog()
        }
        binding.buttonContinuar.setOnClickListener {
            var c:Calendar = Calendar.getInstance()
            if(pickedDate){
                if(c.get(Calendar.YEAR) - año   > 18){
                    Toast.makeText(this,"Eres mayor de Edad, excelente ",Toast.LENGTH_SHORT).show()
                }
                else if( c.get(Calendar.YEAR) - año == 18){
                    if(mes > c.get(Calendar.MONTH)){
                        Toast.makeText(this,"Eres mayor de Edad, excelente",Toast.LENGTH_SHORT).show()
                    }
                    else if(mes == c.get(Calendar.MONTH)){
                       if(dia >= c.get(Calendar.DAY_OF_MONTH)){
                           Toast.makeText(this,"Eres mayor de edad, excelente",Toast.LENGTH_SHORT).show()
                       }

                        else{
                           Toast.makeText(this,"Eres menor de edad, no puedes ingresar, estas a días",Toast.LENGTH_SHORT).show()
                        }
                    }
                    else{
                        Toast.makeText(this,"Eres menor de edad, no puedes ingresar, estas a meses",Toast.LENGTH_SHORT).show()
                    }

                }
                else{
                    Toast.makeText(this,"Eres menor de edad, no puedes ingresar ",Toast.LENGTH_SHORT).show()
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