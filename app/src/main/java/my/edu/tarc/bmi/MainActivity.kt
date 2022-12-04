package my.edu.tarc.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.bmi.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
//    Module Level Variable = can be accessed by all module
//    lateinit var = late initialize, give value later on
//    val = value, var = variable
    private lateinit var binding: ActivityMainBinding //associated with the layout
//    recommend to use this view binder so no need to do multiple times
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Inflate = display the IU
        binding = ActivityMainBinding.inflate(layoutInflater)
//        root = top of a tree structure -> layout
        setContentView(binding.root) //load activity layout file to the memory
        //Local Variable = any defined value within the scope

        binding.buttonReset.setOnClickListener{

        }

        binding.buttonCalculate.setOnClickListener{
            if(binding.editTextHeight.text.isEmpty()) {
                binding.editTextHeight.setError(getString(R.string.value_required))
            return@setOnClickListener
            }

            if(binding.editTextWeight.text.isEmpty()) {
                binding.editTextWeight.setError(getString(R.string.value_required))
                return@setOnClickListener
            }

            val weight = binding.editTextWeight.text.toString().toFloat()
            val height = binding.editTextHeight.text.toString().toFloat()
            val bmi = weight / (height/100).pow(2)

            if(bmi < 18.5){
                //Underweight
                //BMI: 18.20 (underweight)
                binding.textViewBMI.text = String.format("%s:%.2f (%s)", getString(R.string.app_name), bmi, getString(R.string.underweight))

                binding.imageViewBMI.setImageResource(R.drawable.under)
            }else if(bmi > 25) {
                //Overweight
                binding.textViewBMI.text = String.format("%s:%.2f (%s)", getString(R.string.app_name), bmi, getString(R.string.overweight))

                binding.imageViewBMI.setImageResource(R.drawable.over)
            }else {
                //Normal
                binding.textViewBMI.text = String.format("%s:%.2f (%s)", getString(R.string.app_name), bmi, getString(R.string.normal))

                binding.imageViewBMI.setImageResource(R.drawable.normal)
            }


        }
    }
}