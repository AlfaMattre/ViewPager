package com.example.smartfort.viewpager.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView
import android.widget.TextView
import com.example.smartfort.viewpager.R

import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        setSupportActionBar(toolbar)
        getIncomingIntent()
    }

    private fun getIncomingIntent(){
        val text = intent.getStringExtra("text_url")
        setIncomingData(text)
    }

    private fun setIncomingData(textUrl: String){
        val text = findViewById<TextView>(R.id.item)
        text.text = textUrl
    }
}
