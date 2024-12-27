package com.example.appgamarrajesus.models

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Alumno::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun alumnoDao(): AlumnoDao
}