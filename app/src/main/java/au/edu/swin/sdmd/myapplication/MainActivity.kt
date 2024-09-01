package au.edu.swin.sdmd.myapplication

import android.content.Context
import androidx.appcompat.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.ChipGroup

data class Instrument(
    val name: String,
    val rating: Float,
    val type: String,
    val price: Int,
    val imageResId: Int
)

class MainActivity : AppCompatActivity() {
    private var currentIndex = 0
    private val instruments = listOf(
        Instrument("Guitar", 4.5f, "String", 100, R.drawable.sample_guitar),
        Instrument("Violin", 4.0f, "String", 80, R.drawable.sample_violin),
        Instrument("Drum", 3.5f, "Percussion", 90, R.drawable.sample_drum),
        Instrument("Flute", 5.0f, "Woodwind", 95, R.drawable.sample_flute)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView: ImageView = findViewById(R.id.imageViewInstrument)
        val nameTextView: TextView = findViewById(R.id.textViewName)
        val ratingBar: RatingBar = findViewById(R.id.ratingBar)
        val typeTextView: TextView = findViewById(R.id.textViewType)
        val priceTextView: TextView = findViewById(R.id.textViewPrice)
        val nextButton: Button = findViewById(R.id.buttonNext)
        val chipGroup: ChipGroup = findViewById(R.id.chipGroup)

        updateUI() // Initial update

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % instruments.size
            updateUI()
        }

        chipGroup.setOnCheckedChangeListener { group, checkedId ->
            // You could extend this to modify the instrument type based on selection
            typeTextView.text = when(checkedId) {
                R.id.chip1 -> "Type: String"
                R.id.chip2 -> "Type: Woodwind"
                else -> "Type: ${instruments[currentIndex].type}"
            }
        }
    }

    private fun updateUI() {
        val instrument = instruments[currentIndex]
        findViewById<ImageView>(R.id.imageViewInstrument).setImageResource(instrument.imageResId)
        findViewById<TextView>(R.id.textViewName).text = "Name: ${instrument.name}"
        findViewById<RatingBar>(R.id.ratingBar).rating = instrument.rating
        findViewById<TextView>(R.id.textViewType).text = "Type: ${instrument.type}"
        findViewById<TextView>(R.id.textViewPrice).text = "Price: ${instrument.price} credits"
    }

    private fun showPickupDialog() {
        AlertDialog.Builder(this)
            .setTitle("Welcome To Riff Rental!")
            .setMessage("Please note that instruments are available for immediate pickup only at our store location.")
            .setPositiveButton("OK", null)
            .show()
    }
}
