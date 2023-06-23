package com.example.kotlin.colorvalue

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ColorViewModel(val dao: ColorDao, application: Application):AndroidViewModel(application) {
    var repository: Repository
    val readAllColors: LiveData<List<Color>>
    init {
        repository = Repository(dao)
        readAllColors = repository.readAllColors
    }
    fun save(color: Color){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addColor(color)
        }
    }

    fun delete(color: Color){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addColor(color)
        }
    }
}