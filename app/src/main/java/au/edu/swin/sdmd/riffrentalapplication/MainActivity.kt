package au.edu.swin.sdm.riffrentalapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private var currentIndex = 0
    private lateinit var instruments: List<Instrument>
    private lateinit var imageView: ImageView
    private lateinit var nameTextView: TextView
    private lateinit var ratingBar: RatingBar
    private lateinit var priceTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        instruments = listOf(
            Instrument("Guitar", 4.5f, "String", 10, "https://example.com/guitar.jpg"),
            Instrument("Drum Set", 3.0f, "Percussion", 15, "https://example.com/drum.jpg"),
            Instrument("Keyboard", 5.0f, "Electronic", 12, "https://example.com/keyboard.jpg")
        )

        imageView = findViewById(R.id.imageViewInstrument)
        nameTextView = findViewById(R.id.textViewName)
        ratingBar = findViewById(R.id.ratingBar)
        priceTextView = findViewById(R.id.textViewPrice)

        findViewById<Button>(R.id.buttonNext).setOnClickListener {
            currentIndex = (currentIndex + 1) % instruments.size
            updateUI()
        }

        updateUI()
    }

    private fun updateUI() {
        val currentInstrument = instruments[currentIndex]
        Picasso.get().load(currentInstrument.imageUrl).into(imageView)
        nameTextView.text = currentInstrument.name
        ratingBar.rating = currentInstrument.rating
        priceTextView.text = "Credits: ${currentInstrument.pricePerMonth}"
    }
}
