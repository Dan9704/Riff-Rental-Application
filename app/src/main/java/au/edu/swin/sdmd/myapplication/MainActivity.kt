package au.edu.swin.sdmd.myapplication

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.ChipGroup

data class Instrument(
    val name: String,
    val rating: Float,
    val type: String,
    val newPrice: Int,
    val usedPrice: Int,
    val newImages: List<Int>,
    val usedImages: List<Int>,
    val soundTrack: Int,
    var isFavorite: Boolean = false
)

class MainActivity : AppCompatActivity() {
    private var currentIndex = 0
    private var currentCondition = "New"
    private var currentImageIndex = 0
    private var mediaPlayer: MediaPlayer? = null
    private val instruments = listOf(
        Instrument(
            "Guitar", 4.5f, "String", 100, 75,
            listOf(R.drawable.guitar_new, R.drawable.guitar_new1, R.drawable.guitar_new2),
            listOf(R.drawable.guitar_used, R.drawable.guitar_used1, R.drawable.guitar_used2),
            R.raw.guitar_sound
        ),
        Instrument(
            "Violin", 4.0f, "String", 80, 60,
            listOf(R.drawable.violin_new, R.drawable.violin_new1, R.drawable.violin_new2),
            listOf(R.drawable.violin_used, R.drawable.violin_used1, R.drawable.violin_used2),
            R.raw.violin_sound
        ),
        Instrument(
            "Drum", 3.5f, "Percussion", 90, 70,
            listOf(R.drawable.drum_new, R.drawable.drum_new1, R.drawable.drum_new2),
            listOf(R.drawable.drum_used, R.drawable.drum_used1, R.drawable.drum_used2),
            R.raw.drum_sound
        ),
        Instrument(
            "Flute", 5.0f, "Woodwind", 95, 65,
            listOf(R.drawable.flute_new, R.drawable.flute_new1, R.drawable.flute_new2),
            listOf(R.drawable.flute_used, R.drawable.flute_used1, R.drawable.flute_used2),
            R.raw.flute_sound
        )
    )
    private var filteredInstruments = instruments.toMutableList() // List to hold filtered results

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showPickupDialog()

        val playSoundButton: Button = findViewById(R.id.buttonPlaySound)
        val nextButton: Button = findViewById(R.id.buttonNext)
        val prevImageButton: Button = findViewById(R.id.buttonPrevImage)
        val nextImageButton: Button = findViewById(R.id.buttonNextImage)
        val chipGroup: ChipGroup = findViewById(R.id.chipGroup)
        val favoriteButton: ImageView = findViewById(R.id.imageViewFavorite)
        val searchBar: EditText = findViewById(R.id.searchBar)
        val borrowButton: Button = findViewById(R.id.buttonBorrow)

        updateUI()

        // Handle sound playback button click
        playSoundButton.setOnClickListener {
            Log.d("MainActivity", "Play Sound button clicked.")
            playInstrumentSound()
        }

        nextButton.setOnClickListener {
            navigateToNextInstrument()
        }

        prevImageButton.setOnClickListener {
            navigateImage(-1)
        }

        nextImageButton.setOnClickListener {
            navigateImage(1)
        }

        chipGroup.setOnCheckedChangeListener { _, checkedId ->
            currentCondition = when (checkedId) {
                R.id.chip1 -> "New"
                R.id.chip2 -> "Used"
                else -> "New"
            }
            currentImageIndex = 0
            updateTypeText()
            updateUI()
        }

        favoriteButton.setOnClickListener {
            toggleFavorite()
        }

        // Add TextWatcher to search bar
        searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterInstruments(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        // Implement the Borrow button and set up the click listener
        borrowButton.setOnClickListener {
            // Prepare data to send
            val currentInstrument = filteredInstruments[currentIndex]

            val intent = Intent(this, BorrowActivity::class.java).apply {
                putExtra("instrument_name", currentInstrument.name)
                putExtra("instrument_price",
                    if (currentCondition == "New") currentInstrument.newPrice else currentInstrument.usedPrice
                )
                putExtra("instrument_type", "Type: ${currentInstrument.type}")
                putExtra("instrument_rating", currentInstrument.rating)
                putExtra("instrument_image_res",
                    if (currentCondition == "New") currentInstrument.newImages[0] else currentInstrument.usedImages[0]
                )
            }
            startActivity(intent)
        }
    }

    private fun filterInstruments(query: String) {
        // Filter the instruments list based on the query
        filteredInstruments = instruments.filter {
            it.name.contains(query, ignoreCase = true)
        }.toMutableList()

        // Reset the current index if the filtered list is not empty
        if (filteredInstruments.isNotEmpty()) {
            currentIndex = 0
            updateUI()
        } else {
            Toast.makeText(this, "No instruments found", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToNextInstrument() {
        if (filteredInstruments.isNotEmpty()) {
            currentIndex = (currentIndex + 1) % filteredInstruments.size
            currentImageIndex = 0
            stopSound()
            updateUI()
        }
    }

    private fun playInstrumentSound() {
        val instrument = filteredInstruments[currentIndex]

        // Stop currently playing sound if any
        stopSound()

        // Play the sound track of the current instrument with error handling
        try {
            mediaPlayer = MediaPlayer.create(this, instrument.soundTrack)
            mediaPlayer?.setOnPreparedListener {
                Log.d("MainActivity", "MediaPlayer prepared and starting.")
                it.start()
            }
            mediaPlayer?.setOnErrorListener { mp, what, extra ->
                Log.e("MainActivity", "Error occurred during playback: what=$what, extra=$extra")
                mp.reset()
                Toast.makeText(this, "Error playing sound.", Toast.LENGTH_SHORT).show()
                true
            }
        } catch (e: Exception) {
            Log.e("MainActivity", "Exception in playing sound: ${e.message}")
            Toast.makeText(this, "Failed to play sound: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun stopSound() {
        mediaPlayer?.release()
        mediaPlayer = null
    }

    private fun updateUI() {
        if (filteredInstruments.isNotEmpty()) {
            val instrument = filteredInstruments[currentIndex]
            val imageView: ImageView = findViewById(R.id.imageViewInstrument)
            val favoriteButton: ImageView = findViewById(R.id.imageViewFavorite)
            val images =
                if (currentCondition == "New") instrument.newImages else instrument.usedImages
            imageView.setImageResource(images[currentImageIndex])

            findViewById<TextView>(R.id.textViewName).text = "Name: ${instrument.name}"
            findViewById<RatingBar>(R.id.ratingBar).rating = instrument.rating
            updateTypeText()
            updatePrice()

            favoriteButton.setImageResource(
                if (instrument.isFavorite) R.drawable.ic_heart_filled else R.drawable.ic_heart_outline
            )
        }
    }

    private fun navigateImage(direction: Int) {
        val instrument = filteredInstruments[currentIndex]
        val images =
            if (currentCondition == "New") instrument.newImages else instrument.usedImages
        currentImageIndex = (currentImageIndex + direction + images.size) % images.size
        updateUI()
    }

    private fun updateTypeText() {
        findViewById<TextView>(R.id.textViewType).text = "Type: $currentCondition"
    }

    private fun updatePrice() {
        val instrument = filteredInstruments[currentIndex]
        val price = if (currentCondition == "New") instrument.newPrice else instrument.usedPrice
        findViewById<TextView>(R.id.textViewPrice).text = "Price Monthly: $price credits"
    }

    private fun toggleFavorite() {
        val instrument = filteredInstruments[currentIndex]
        instrument.isFavorite = !instrument.isFavorite
        updateUI()
    }

    private fun showPickupDialog() {
        AlertDialog.Builder(this)
            .setTitle("Welcome To Riff Rental!")
            .setMessage("Please note that instruments are available for immediate pickup only at our store location.")
            .setPositiveButton("OK", null)
            .show()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopSound() // Ensure sound stops when the activity is destroyed
    }
}
