package com.example.appgamarrajesus.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AlumnoDao {

    // Insertar un alumno en la base de datos
    @Insert
    suspend fun insertarAlumno(alumno: Alumno)

    // Consultar un alumno por código y contraseña
    @Query("SELECT * FROM tbljesus WHERE codalumno = :codigo AND password = :password LIMIT 1")
    suspend fun autenticarAlumno(codigo: String, password: String): Alumno?

    // Obtener todos los alumnos (opcional, por si necesitas listar)
    @Query("SELECT * FROM tbljesus")
    suspend fun obtenerTodosLosAlumnos(): List<Alumno>
}