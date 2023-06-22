package com.example.kotlin.colorvalue

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.colorvalue.Adapters.ColorApater
import com.example.kotlin.colorvalue.databinding.ActivityMainBinding

class MainActivity: Activity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter : ColorApater = ColorApater()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeBinding()

        val colorDao = ColorDatabase.invoke(application).colorDao()
        val newColor = Color(0,hex = "#00722e", name = "verde")
        Log.i("New_Color", newColor.hex + " -> "+newColor.name )
        //colorDao.insert(newColor)
        var dataT = colorDao.getAll()

        //Llamar al método para la creación del recyclerView enviandole los datos otenidos del Room
        setUpRecyclerView(dataT)
        Log.i("Quantity_Colors", dataT.size.toString() )

    }

    private  fun initializeBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView( binding.root )

    }

    private fun setUpRecyclerView (arrayList: Array<Color>){
        binding.recyclerColor.setHasFixedSize(true)
        var linearLayoutManager = LinearLayoutManager( this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerColor.layoutManager = linearLayoutManager
        adapter.ColorApater(arrayList, this)
        binding.recyclerColor.adapter = adapter
    }
}