package au.edu.swin.sdm.riffrentalapplication

import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import au.edu.swin.sdmd.riffrentalapplication.R

@Parcelize
data class Instrument(
    val name: String,
    val rating: Float,
    val type: String,
    val pricePerMonth: Int
) : Parcelable

class MainActivity : AppCompatActivity() {

    private var currentIndex = 0
    private lateinit var instruments: List<Instrument>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize sample data
        instruments = listOf(
            Instrument("Guitar", 4.5f, "String", 10),
            Instrument("Drum Set", 3.0f, "Percussion", 15),
            Instrument("Keyboard", 5.0f, "Electronic", 12)
        )

        updateUI()

        val buttonNext = findViewById<Button>(R.id.buttonNext)
        buttonNext.setOnClickListener {
            currentIndex = (currentIndex + 1) % instruments.size
            updateUI()
        }
    }

    private fun updateUI() {
        val textViewName = findViewById<TextView>(R.id.textViewName)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val textViewPrice = findViewById<TextView>(R.id.textViewPrice)

        textViewName.text = instruments[currentIndex].name
        ratingBar.rating = instruments[currentIndex].rating
        textViewPrice.text = "Credits: ${instruments[currentIndex].pricePerMonth}"
    }
}
