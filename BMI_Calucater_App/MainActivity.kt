import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editTextHeight: EditText
    private lateinit var editTextWeight: EditText
    private lateinit var editTextAge: EditText
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextHeight = findViewById(R.id.editTextHeight)
        editTextWeight = findViewById(R.id.editTextWeight)
        editTextAge = findViewById(R.id.editTextAge)
        textViewResult = findViewById(R.id.textViewResult)

        val calculateButton: Button = findViewById(R.id.buttonCalculate)

        calculateButton.setOnClickListener(View.OnClickListener {
            calculateBMI()
        })
    }

    private fun calculateBMI() {
        val height: Double = editTextHeight.text.toString().toDouble() / 100 // Convert to meters
        val weight: Double = editTextWeight.text.toString().toDouble()
        val age: Int = editTextAge.text.toString().toInt()

        val bmi: Double = weight / (height * height)
        val rating: String = calculateRating(bmi, age)

        textViewResult.text = "BMI: $bmi\nRating: $rating"
    }

    private fun calculateRating(bmi: Double, age: Int): String {
        // Add your rating logic here
        // Example: You can define your own rating thresholds and return a rating based on them.
        if (bmi < 18.5) {
            return "Underweight"
        } else if (bmi < 24.9) {
            return "Normal Weight"
        } else if (bmi < 29.9) {
            return "Overweight"
        } else {
            return "Obese"
        }
    }
}
