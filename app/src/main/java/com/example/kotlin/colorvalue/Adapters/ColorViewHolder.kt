package com.example.kotlin.colorvalue.Adapters

import android.content.Context
import androidx.core.graphics.toColorInt
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.colorvalue.Color
import com.example.kotlin.colorvalue.databinding.ItemColorBinding

class ColorViewHolder(private val binding: ItemColorBinding): RecyclerView.ViewHolder( binding.root ) {
    fun bin(item: Color, context: Context){
        binding.contentColor.text = item.name
        var colort = android.graphics.Color.parseColor(item.hex)
        binding.contentColor.setBackgroundColor(colort)
    }
}