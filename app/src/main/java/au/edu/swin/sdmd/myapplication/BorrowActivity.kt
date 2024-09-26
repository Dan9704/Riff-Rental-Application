package au.edu.swin.sdmd.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BorrowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrow)

        // Get instrument details passed from MainActivity
        val instrumentName = intent.getStringExtra("instrument_name") ?: "Instrument"
        val instrumentPrice = intent.getIntExtra("instrument_price", 0)
        val instrumentType = intent.getStringExtra("instrument_type") ?: "Type: Unknown"
        val instrumentRating = intent.getFloatExtra("instrument_rating", 0f)
        val instrumentImageRes = intent.getIntExtra("instrument_image_res", R.drawable.drum_new)

        // Set the received data to respective views
        val nameTextView: TextView = findViewById(R.id.textViewInstrumentName)
        val priceTextView: TextView = findViewById(R.id.textViewInstrumentPrice)
        val typeTextView: TextView = findViewById(R.id.textViewInstrumentType)
        val ratingBar: RatingBar = findViewById(R.id.ratingBarInstrument)
        val imageView: ImageView = findViewById(R.id.imageViewInstrument)

        nameTextView.text = "Instrument: $instrumentName"
        priceTextView.text = "Price: $instrumentPrice credits"
        typeTextView.text = instrumentType
        ratingBar.rating = instrumentRating
        imageView.setImageResource(instrumentImageRes)

        // Handle submit button click
        val submitButton: Button = findViewById(R.id.buttonSubmit)
        submitButton.setOnClickListener {
            val name = findViewById<EditText>(R.id.editTextName).text.toString()
            val email = findViewById<EditText>(R.id.editTextEmail).text.toString()

            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Save booking
                Toast.makeText(this, "Submission successful", Toast.LENGTH_SHORT).show()
            }
        }

        // Handle back to home button click
        val backButton: Button = findViewById(R.id.buttonBackToHome)
        backButton.setOnClickListener {
            finish() // Go back to MainActivity
        }
    }
}
