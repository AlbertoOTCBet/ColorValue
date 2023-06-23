package com.example.kotlin.colorvalue

import androidx.lifecycle.LiveData

class Repository (private val dao: ColorDao) {
    val readAllColors: LiveData<List<Color>> = dao.getAll()

    suspend  fun addColor (color: Color) {
        dao.insert(color)
    }

    suspend fun delete ( color: Color){
        dao.delete(color)
    }
}