package hu.petrik.CoinFlip

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.*

lateinit var coin : ImageView
lateinit var buttonFej : Button
lateinit var buttonIras : Button
lateinit var textVievTries : TextView
lateinit var textVievWin : TextView
lateinit var textVievLose : TextView
lateinit var random : Random
var tries : Int = 0
var win : Int = 0
var lose : Int = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        buttonFej.setOnClickListener() {
            var eredmeny = random.nextInt(2)
            coin.animate().apply {
                duration = 300
                rotationXBy(360F)
            }.withEndAction {
                if (win != 3 && lose != 3) {
                    if (eredmeny == 1) {
                        coin.setImageResource(R.drawable.heads)
                        win++
                        textVievWin.setText("Győzelem: " + win)
                    } else {
                        coin.setImageResource(R.drawable.tails)
                        lose++
                        textVievLose.setText("Vereség: " + lose)
                    }
                    tries++
                    textVievTries.setText("Dobások: " + tries)
                }
                gameEnd()
            }
        }

        buttonIras.setOnClickListener() {
            var eredmeny = random.nextInt(2)
            coin.animate().apply {
                duration = 300
                rotationXBy(360F)
            }.withEndAction {
                if (win != 3 && lose != 3) {
                    if (eredmeny == 1) {
                        coin.setImageResource(R.drawable.tails)
                        win++
                        textVievWin.setText("Győzelem: " + win)
                    } else {
                        coin.setImageResource(R.drawable.heads)
                        lose++
                        textVievLose.setText("Vereség: " + lose)
                    }
                    tries++
                    textVievTries.setText("Dobások: " + tries)
                }
                gameEnd()
            }
        }
    }

    fun init() {
        coin = findViewById(R.id.imageViewCoin)
        buttonFej = findViewById(R.id.buttonFej)
        buttonIras = findViewById(R.id.buttonIras)
        textVievTries = findViewById(R.id.textViewTries)
        textVievWin = findViewById(R.id.textViewWin)
        textVievLose = findViewById(R.id.textViewLose)
        random = Random()
    }

    private fun gameEnd() {
        if (win == 3) {
            val builder = AlertDialog.Builder(this)
                .setTitle("Győzelem")
                .setMessage("Szeretne új játékot játszani?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id ->
                    reset()
                }
                .setNegativeButton("Nem") { dialog, id ->
                    finishAffinity()
                }.show()
        } else if (lose == 3) {
            val builder = AlertDialog.Builder(this)
                .setTitle("Vereség")
                .setMessage("Szeretne új játékot játszani?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id ->
                    reset()
                }
                .setNegativeButton("Nem") { dialog, id ->
                    finishAffinity()
                }.show()
        }
    }

    private fun reset() {
        coin.setImageResource(R.drawable.heads)
        tries = 0
        win = 0
        lose = 0
        textVievTries.setText("Dobások: " + tries)
        textVievWin.setText("Győzelem: " + win)
        textVievLose.setText("Vereség: " + lose)
    }
}