package com.example.calculatorwithfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculatorwithfragment.ButtonPanel
import com.example.calculatorwithfragment.R


class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, ButtonPanel())
            .commit()

    }
}