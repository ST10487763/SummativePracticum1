package za.ac.iie

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Arrays

class MainActivity() : AppCompatActivity() {
    companion object {
        // Used to show the parallel arrays within the code
        private val songArray = ArrayList<String>()
        private val artistArray = ArrayList<String>()
        private val ratingArray = ArrayList<String>()
        private val commentArray = ArrayList<String>()
    }
    // used to add to the counter for the array
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnExit = findViewById<Button>(R.id.btnExit)
        val edtSong = findViewById<EditText>(R.id.edtSong)
        val edtArtist = findViewById<EditText>(R.id.edtArtist)
        val edtRating = findViewById<EditText>(R.id.edtRating)
        val edtComments = findViewById<EditText>(R.id.edtUser)

        //When button is pressed it asks the user to import the information
        btnAdd.setOnClickListener {
            playlistInfo()
            val inputText = edtSong.text.toString()
            if (inputText.isNotEmpty()) {
                songArray.add(inputText)
                edtSong.text.clear()
                songArray[counter]
            }
            if (inputText.isNotEmpty()){
                artistArray.add(inputText)
                edtArtist.text.clear()
                artistArray[counter]
            }
            if (inputText.isNotEmpty()) {
                commentArray.add(inputText)
                edtComments.text.clear()
                artistArray[counter]
            }
            if (inputText.isNotEmpty()) {
                ratingArray.run { add(inputText) }
                edtRating.text.clear()
                ratingArray[counter]
            }
            counter++

            btnNext.setOnClickListener {
                val intent = Intent(this, DetailedViewActivity::class.java)
                startActivity(intent)
            }

            // When clicked allows the user to exit the app
            btnExit.setOnClickListener {
                finishAffinity()
            }

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
    private fun playlistInfo() {
        val size = readLine()?.toIntOrNull() ?: 0
        val songArray = Array(5) { " " }
        val artistArray = Array(5) { " " }
        val ratingArray = Array(5) { " " }
        val commentArray = Array(5) { " " }
    }