package vcmsa.ci.feasttime

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var inputEditText: EditText
    private lateinit var generateBtn: Button
    private lateinit var clearBtn: Button
    private lateinit var exitBtn: Button
    private lateinit var answer: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        inputEditText = findViewById(R.id.inputEditText)
        generateBtn = findViewById(R.id.generalBtn)
        clearBtn = findViewById(R.id.clearBtn)
        exitBtn = findViewById(R.id.exitBtn)
        answer = findViewById(R.id.answer)

        generateBtn.setOnClickListener {
            matchTimeToMeal()
        }
        clearBtn.setOnClickListener {
            clearBtnMatchOnClick()
        }
        exitBtn.setOnClickListener(){
            exitBtnMatchOnClick()
        }
    }

    private fun timeInputisNotEmpty() : Boolean{

        var t = true
        if (inputEditText.text.toString().trim().isEmpty()){
            inputEditText.error = "Input required"
            t = false
        }
        return t
    }

    private fun matchTimeToMeal() {
        if (timeInputisNotEmpty()) {

        val timeInput = answer.text.toString()
        var time = timeInput.toIntOrNull()
        if (time == null) {
            answer.text = "Invalid Time!"

        }
        if (time != null) {
            if (time < 500 || time > 2230) {
                answer.text = "Invalid Time!"
            }
        }

        val meal = inputEditText.text.toString().trim().toInt()

        when (meal) {
            in 500..859 -> answer.text = "Buttermilk Pancake\n French Toast\n Avocado Toast\n (Green, Berry, Banna)Smoothie"
            in 900..1159 -> answer.text = "Jungle Energy Bar\n (Carrot, Pumpkin, Coffee) Muffin\n Ricotta and Yogurt Parfait"
            in 1200..1459 -> answer.text = "Veggie Wrap\n Mexican Wrap\n Mexican Pinewheel\n Antipasto Salad"
            in 1500..1759 -> answer.text = "Popcorn\n (Chcolate,Vanilla,Carrot)Cake\n Sweets\n Pretzel\n Crackers"
            in 1800..2059 -> answer.text = "Meatball Casserol \n Chicken Nachos\n Creamy Chicken Noodles\n Supreme Pizza"
            in 2100..2230 -> answer.text = "Milk Tart\n Koeksisters\n Malva Pudding\n Ice-cream\n Churros"

            else -> {
                answer.text = "Invalid Time!"
            }
        }}

    }

    private fun clearBtnMatchOnClick() {
        inputEditText.text.clear()
        answer.text = ""
    }

    private fun exitBtnMatchOnClick() {
        finishAffinity()
        exitProcess(0)
    }

}