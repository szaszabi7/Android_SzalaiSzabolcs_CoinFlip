package hu.petrik.CoinFlip

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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
            var eredmeny = random.nextBoolean()
            if (tries == 5 && win < lose) {
                alertLose()
            } else if (tries == 5 && win > lose) {
                alertWin()
            } else {
                if (eredmeny) {
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
        }
        buttonIras.setOnClickListener() {
            var eredmeny = random.nextBoolean()
            if (tries == 5 && win < lose) {
                alertLose()
            } else if (tries == 5 && win > lose) {
                alertWin()
            } else {
                if (eredmeny) {
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

    private fun alertLose() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Vereség")
        builder.setMessage("Szeretne új játékot játszani?")
        builder.setPositiveButton("Yes") { _: DialogInterface, _: Int ->
            reset()
        }
        builder.setNegativeButton("Nem") { _: DialogInterface, _: Int ->
            finish()
            reset()
        }
        builder.show()
    }

    private fun alertWin() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Győzelem")
        builder.setMessage("Szeretne új játékot játszani?")
        builder.setPositiveButton("Yes") { _: DialogInterface, _: Int ->
            reset()
        }
        builder.setNegativeButton("Nem") { _: DialogInterface, _: Int ->
            finish()
            reset()
        }
        builder.show()
    }

    fun reset() {
        coin.setImageResource(R.drawable.heads)
        tries = 0
        win = 0
        lose = 0
        textVievTries.setText("Dobások: " + tries)
        textVievWin.setText("Győzelem: " + win)
        textVievLose.setText("Vereség: " + lose)
    }
}