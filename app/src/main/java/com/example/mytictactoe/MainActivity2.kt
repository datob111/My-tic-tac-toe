package com.example.mytictactoe

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.toColorLong

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var resetButton: Button
    private lateinit var point1:TextView
    private lateinit var point2:TextView
    private lateinit var player1:TextView
    private lateinit var player2:TextView
    private var activePlayer = 1
    private var counter1=0
    private var counter2=0
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()
private lateinit var back:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val import1=intent.extras?.getString("player1")
        val import2=intent.extras?.getString("player2")
        setContentView(R.layout.activity_main2)
        point1=findViewById(R.id.point1)
        point2=findViewById(R.id.point2)
        player1=findViewById(R.id.player1)
        player2=findViewById(R.id.player2)
        player1.text=import1.toString()
        player2.text=import2.toString()
        if (import1.toString()=="") player1.text="player1"
        if (import2.toString()=="") player2.text="player2"
        back=findViewById(R.id.back)
        back.setOnClickListener {
            var k=Intent(this,MainActivity::class.java)
            startActivity(k)
        }
        init()


    }

    private fun init() {
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        resetButton = findViewById(R.id.buttonreset)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {
            var buttonNumber = 0
            when (clickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }

            if (buttonNumber !=0){
                playGame(clickedView,buttonNumber)
            }

        }

    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if (activePlayer == 1){
            clickedView.text = "X"
            clickedView.setTextColor(Color.rgb(0,0,0))
            player1.setTextColor(Color.rgb(1,99,3))
            clickedView.setBackgroundColor(Color.rgb(99,99,99))
            activePlayer = 2
            player2.setTextColor(Color.rgb(99,77,0))
            firstPlayer.add(buttonNumber)
        } else if (activePlayer == 2) {
            clickedView.text = "O"
            clickedView.setBackgroundColor(Color.rgb(97,67,12))
            player2.setTextColor(Color.rgb(1,99,3))
            clickedView.setTextColor(Color.rgb(0,0,0))
            player1.setTextColor(Color.rgb(99,77,0))
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }

        clickedView.isEnabled = false
        check()


    }
    private fun check(){
        var winnerPlayer = 0


        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winnerPlayer = 1
            counter1+=1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winnerPlayer = 2
            counter2+=1
        }

        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winnerPlayer = 1
            counter1+=1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winnerPlayer = 2
            counter2+=1
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)){
            winnerPlayer = 1
            counter1+=1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winnerPlayer = 2
            counter2+=1
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)){
            winnerPlayer = 1
            counter1+=1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)){
            winnerPlayer = 2
            counter2+=1
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)){
            winnerPlayer = 1
            counter1+=1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)){
            winnerPlayer = 2
            counter2+=1
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)){
            winnerPlayer = 1
            counter1+=1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winnerPlayer = 2
            counter2+=1
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)){
            winnerPlayer = 1
            counter1+=1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winnerPlayer = 2
            counter2+=1
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(5) && firstPlayer.contains(3)){
            winnerPlayer = 1
            counter1+=1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(5) && secondPlayer.contains(3)){
            winnerPlayer = 2
            counter2+=1
        }
        if (winnerPlayer == 1){
            Toast.makeText(this,"${player1.text} is the winner",Toast.LENGTH_SHORT).show()
        }
        if (winnerPlayer == 2){
            Toast.makeText(this," ${player2.text} is the winner",Toast.LENGTH_SHORT).show()
        }
        if (firstPlayer.size + secondPlayer.size == 9 && winnerPlayer == 0){
            Toast.makeText(this,"draw",Toast.LENGTH_SHORT).show()
        }
        if (winnerPlayer!=0){
            button1.isEnabled=false
            button2.isEnabled=false
            button3.isEnabled=false
            button4.isEnabled=false
            button5.isEnabled=false
            button6.isEnabled=false
            button7.isEnabled=false
            button8.isEnabled=false
            button9.isEnabled=false
        }
        if(winnerPlayer==1){

            point1.text="$counter1"

        }
        if (winnerPlayer==2){

            point2.text="$counter2"

        }

    }

    fun reset(clickedView: View?){
        if (clickedView is Button){
            if (clickedView.id==R.id.buttonreset){
                button1.text=""
                button1.isEnabled =true
                button1.setBackgroundColor(Color.rgb(78,10,2))
                button2.text=""
                button2.isEnabled =true
                button2.setBackgroundColor(Color.rgb(78,10,2))
                button3.text=""
                button3.isEnabled =true
                button3.setBackgroundColor(Color.rgb(78,10,2))
                button4.text=""
                button4.isEnabled =true
                button4.setBackgroundColor(Color.rgb(78,10,2))
                button5.text=""
                button5.isEnabled =true
                button5.setBackgroundColor(Color.rgb(78,10,2))
                button6.text=""
                button6.isEnabled =true
                button6.setBackgroundColor(Color.rgb(78,10,2))
                button7.text=""
                button7.isEnabled =true
                button7.setBackgroundColor(Color.rgb(78,10,2))
                button8.text=""
                button8.isEnabled =true
                button8.setBackgroundColor(Color.rgb(78,10,2))
                button9.text=""
                button9.isEnabled =true
                button9.setBackgroundColor(Color.rgb(78,10,2))
                firstPlayer.clear()
                secondPlayer.clear()
                activePlayer=1
                player1.setTextColor(Color.rgb(99,77,0))
                player2.setTextColor(Color.rgb(99,77,0))

            }
        }

    }
    fun endgame(clickedView: View?){
        if (clickedView is Button){
            counter1=0
            counter2=0
            point1.text="0"
            point2.text="0"
            button1.text=""
            button1.isEnabled =true
            button1.setBackgroundColor(Color.rgb(78,10,2))
            button2.text=""
            button2.isEnabled =true
            button2.setBackgroundColor(Color.rgb(78,10,2))
            button3.text=""
            button3.isEnabled =true
            button3.setBackgroundColor(Color.rgb(78,10,2))
            button4.text=""
            button4.isEnabled =true
            button4.setBackgroundColor(Color.rgb(78,10,2))
            button5.text=""
            button5.isEnabled =true
            button5.setBackgroundColor(Color.rgb(78,10,2))
            button6.text=""
            button6.isEnabled =true
            button6.setBackgroundColor(Color.rgb(78,10,2))
            button7.text=""
            button7.isEnabled =true
            button7.setBackgroundColor(Color.rgb(78,10,2))
            button8.text=""
            button8.isEnabled =true
            button8.setBackgroundColor(Color.rgb(78,10,2))
            button9.text=""
            button9.isEnabled =true
            button9.setBackgroundColor(Color.rgb(78,10,2))
            activePlayer=1
            firstPlayer.clear()
            secondPlayer.clear()
            player1.setTextColor(Color.rgb(99,77,0))
            player2.setTextColor(Color.rgb(99,77,0))
        }
    }
}

