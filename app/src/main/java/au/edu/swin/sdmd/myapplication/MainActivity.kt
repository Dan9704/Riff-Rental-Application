package au.edu.swin.sdmd.myapplication

import Instrument
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var currentIndex = 0
    private val instruments = listOf(
        Instrument("Guitar", 4.5f, "String", 100),
        Instrument("Violin", 4.8f, "String", 80),
        Instrument("Drum", 4.3f, "Percussion", 90)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameTextView: TextView = findViewById(R.id.textViewName)
        val ratingBar: RatingBar = findViewById(R.id.ratingBar)
        val typeTextView: TextView = findViewById(R.id.textViewType)
        val priceTextView: TextView = findViewById(R.id.textViewPrice)
        val nextButton: Button = findViewById(R.id.buttonNext)

        updateUI() // Initial update

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % instruments.size
            updateUI()
        }
    }

    private fun updateUI() {
        val instrument = instruments[currentIndex]
        findViewById<TextView>(R.id.textViewName).text = "Name: ${instrument.name}"
        findViewById<RatingBar>(R.id.ratingBar).rating = instrument.rating
        findViewById<TextView>(R.id.textViewType).text = "Type: ${instrument.type}"
        findViewById<TextView>(R.id.textViewPrice).text = "Price: ${instrument.pricePerMonth} credits"
    }
}
