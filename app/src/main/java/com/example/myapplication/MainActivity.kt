package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    var numara = 0;
    var runnable : Runnable = Runnable(){ }
    var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun basla(view: View) {
        numara = 0
        runnable = object : Runnable {
            override fun run() {
                numara = numara + 1
                val textView : TextView = findViewById(R.id.textView) as TextView
                textView.text = "Sayaç : ${numara}"
                handler.postDelayed(runnable,1000)

            }
        }
        handler.post(runnable)
    }
    fun durdur(view: View){
        handler.removeCallbacks(runnable)
        numara = 0
        val textView : TextView = findViewById(R.id.textView) as TextView
        textView.text="Sayaç : 0"
    }
}