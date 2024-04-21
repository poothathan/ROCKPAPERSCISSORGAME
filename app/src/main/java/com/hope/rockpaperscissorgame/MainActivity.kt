package com.hope.rockpaperscissorgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Images
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var name: EditText? = null
    var score1: Int = 0
    var score2: Int = 0
    var player : TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.name)
    }

    fun next(view: View) {
        setContentView(R.layout.activity_main2)

        player = findViewById(R.id.player)
        var text1 = findViewById<TextView>(R.id.text1)
        var text2 = findViewById<TextView>(R.id.text2)

        var image1 = findViewById<ImageView>(R.id.image1)
        var image2 = findViewById<ImageView>(R.id.image2)
        var image3 = findViewById<ImageView>(R.id.image3)
        var image4 = findViewById<ImageView>(R.id.image4)
        var image5 = findViewById<ImageView>(R.id.image5)


        var image = listOf(R.drawable.rock, R.drawable.paper, R.drawable.scissors)

        var rock = R.drawable.rock
        var paper = R.drawable.paper
        var scissor = R.drawable.scissors

        player?.text = name?.text

        image3.setOnClickListener {
            image2.setImageResource(R.drawable.rock)
            var random: Int = Random.nextInt(0, 2)
            image1.setImageResource(image[random])

            if (image[random] == R.drawable.paper) {
                score1++
            }

            if (image[random] == R.drawable.scissors) {
                score2++
            }
            text1.text = score1.toString()
            text2.text = score2.toString()

            if(score1 == 3 || score2 == 3) {
                repeat(view)
            }
        }


        image4.setOnClickListener {
            image2.setImageResource(R.drawable.paper)
            var random: Int = Random.nextInt(0, 2)
            image1.setImageResource(image[random])

            if (image[random] == R.drawable.scissors) {
                score1++
            }

            if (image[random] == R.drawable.rock) {
                score2++
            }
            text1.text = score1.toString()
            text2.text = score2.toString()

            if(score1 == 3 || score2 == 3) {
                repeat(view)
            }
        }


        image5.setOnClickListener {
            image2.setImageResource(R.drawable.scissors)
            var random: Int = Random.nextInt(0, 2)
            image1.setImageResource(image[random])

            if (image[random] == R.drawable.rock) {
                score1++
            }

            if (image[random] == R.drawable.paper) {
                score2++
            }
            text1.text = score1.toString()
            text2.text = score2.toString()

            if(score1 == 3 || score2 == 3) {
                repeat(view)
            }
        }
    }

    fun repeat(view: View) {

        setContentView(R.layout.activity_main3)
        var text3 = findViewById<TextView>(R.id.text3)
        var image6 = findViewById<ImageView>(R.id.image6)

        if(score1 == 3) {
            image6.setImageResource(R.drawable.loser)
            text3.text = "YOU LOSE THE GAME"
        }
        else {
            image6.setImageResource(R.drawable.trophy)
            text3.text = "YOU WON THE GAME"
        }
    }

    fun yes(view: View) {
        player?.text = ""
        score1 = 0
        score2 = 0
        next(view)
    }

    fun no(view: View) {

    }

}