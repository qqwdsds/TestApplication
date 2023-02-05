package com.example.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.testapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //ViewBinding
    lateinit var component: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component = ActivityMainBinding.inflate(layoutInflater)
        setContentView(component.root)

        component.isDoneButton.setOnClickListener{
            if(component.enterText.text.toString() != ""){
                val text = component.enterText.text.toString()
                when(text.filter{!it.isWhitespace()}.lowercase()){
                    "android" -> {
                        component.image.visibility = View.VISIBLE
                        component.image.setImageResource(choose.ANDROID)
                    }
                    "terminal" -> {
                        component.image.visibility = View.VISIBLE
                        component.image.setImageResource(choose.TERMINAL)
                    }
                    "youtube" -> {
                        component.image.visibility = View.VISIBLE
                        component.image.setImageResource(choose.YOUTUBE)
                    }
                    else -> component.image.visibility = View.INVISIBLE
                }
            }
        }
    }
}

//Singleton Class
object choose{
    const val ANDROID = R.drawable.android
    const val TERMINAL = R.drawable.terminal
    const val YOUTUBE = R.drawable.youtube
}