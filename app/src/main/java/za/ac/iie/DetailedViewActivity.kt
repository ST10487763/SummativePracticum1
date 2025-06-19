package za.ac.iie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Arrays

class DetailedViewActivity : AppCompatActivity() {
    companion object{
        // displays the parallel arrays used within the program which are used
        val songArray = ArrayList<String>()
        val artistArray = ArrayList<String>()
        val ratingArray = ArrayList<Int>()
        val commentArray = ArrayList<String>()
    }
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view)

        // identifies the variables and its id in order to use the app effectively
        val btnDisplay = findViewById<Button>(R.id.btnDisplay)
        val btnReturn = findViewById<Button>(R.id.btnReturn)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val txtResults = findViewById<TextView>(R.id.txtResults)
        var txtDisplay = " "
        var songDisplay = " "

        // allows the user to display information regarding the playlist
        btnDisplay.setOnClickListener{
            var counter = 0
            while (counter > 5){
                songDisplay += "${songArray[counter]}\n" + " ${artistArray[counter]}\n" + "${commentArray[counter]}\n" + "${ratingArray[counter]}\n"
                counter ++
                txtResults.text= songDisplay
            }

        }
        // a formula on how to calculate the average ratings within the playlist
        btnReturn.setOnClickListener{
           val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        //used to display the calculation for the rating
        btnCalculate.setOnClickListener{
            var i = ratingArray
            while (i >= 5)
            {
                txtDisplay ="Your average song rating is: $i/2"
                txtResults.text = txtDisplay

            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets -> val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

private operator fun <E> ArrayList<E>.compareTo(e: E): Int {
    return TODO("Provide the return value")
}

