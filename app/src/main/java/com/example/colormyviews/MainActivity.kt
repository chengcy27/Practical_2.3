package com.example.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun genColor(): Int{
        return (Color.argb(255,(0..255).random(),(0..255).random(),(0..255).random()))
    }

    private fun makeColored(view: View){

        when (view.id){
            R.id.box_one_text -> view.setBackgroundColor(genColor())
            R.id.box_two_text -> view.setBackgroundColor(genColor())
            R.id.box_three_text -> view.setBackgroundColor(genColor())
            R.id.box_four_text -> view.setBackgroundColor(genColor())
            R.id.box_five_text -> view.setBackgroundColor(genColor())

            // Boxes using custom colors for background
            R.id.red_button -> box_three_text.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> box_four_text.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> box_five_text.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(genColor())
        }
    }

    private fun setListeners(){

        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)
        val redButton = findViewById<TextView>(R.id.red_button)
        val greenButton = findViewById<TextView>(R.id.green_button)
        val yellowButton = findViewById<TextView>(R.id.yellow_button)

        val rootConstraintElement = findViewById<View>(R.id.constraint_layout)

        val clickableViews: List <View> =
            listOf(boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, rootConstraintElement,
                redButton, greenButton, yellowButton
            )

        for (item in clickableViews){
            item.setOnClickListener{makeColored(it)}
        }


    }
}