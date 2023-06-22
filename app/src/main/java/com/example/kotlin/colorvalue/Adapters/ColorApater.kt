package com.example.kotlin.colorvalue.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.colorvalue.Color
import com.example.kotlin.colorvalue.databinding.ItemColorBinding

class ColorApater: RecyclerView.Adapter<ColorViewHolder>() {
    lateinit var data: Array<Color>
    lateinit var contex: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val binding =ItemColorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ColorViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        var item = data[position]
        holder.bin( item, contex)
    }

    fun ColorApater(dataBasic: Array<Color>, context: Context){
        this.data = dataBasic
        this.contex = context
    }
}