package com.example.kotlin.colorvalue

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ColorViewModel(val dao: ColorDao, application: Application):AndroidViewModel(application) {
    fun save(color: Color){
        viewModelScope.launch {
            dao.insert(color)
        }
    }

    fun getAllColors(){
        viewModelScope.launch {
            var dataF = dao.getAll()
            Log.i("ColorVoe", dataF.size.toString())
        }
    }
}