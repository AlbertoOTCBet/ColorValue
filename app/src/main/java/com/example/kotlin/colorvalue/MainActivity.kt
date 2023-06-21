package com.example.kotlin.colorvalue

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.example.kotlin.colorvalue.databinding.ActivityMainBinding

class MainActivity: Activity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeBinding()

        val colorDao = ColorDatabase.getInstance(application).colorDao()
        val newColor = Color(0,hex = "#6200EE", name = "purple")
        Log.i("New_Color", newColor.hex + " -> "+newColor.name )
        colorDao.insert(newColor)

    }

    private  fun initializeBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView( binding.root )

    }
}