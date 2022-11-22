package com.example.mytictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var startgame:Button
    private lateinit var edittext1:EditText
    private lateinit var edittext2:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startgame=findViewById(R.id.startgame)
        edittext1=findViewById(R.id.edittext1)
        edittext2=findViewById(R.id.edittext2)
        startgame.setOnClickListener{
            var i=Intent(this,MainActivity2::class.java)
            val x=edittext1.text.toString()
            val y=edittext2.text.toString()
            i.putExtra("player1",x)
            i.putExtra("player2",y)
            startActivity(i)
        }

    }
}