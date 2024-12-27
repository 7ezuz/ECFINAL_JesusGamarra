package com.example.appgamarrajesus.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
    (tableName = "alumnos")
data class Alumno(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // ID autogenerado
    val codalumno: String,
    val password: String,
    val nombreapellido: String,
    val especialidad: String
) {
    init {
        require(codalumno.isNotBlank()) { "El código del alumno no puede estar vacío." }
        require(password.isNotBlank()) { "La contraseña no puede estar vacía." }
        require(nombreapellido.isNotBlank()) { "El nombre no puede estar vacío." }
        require(especialidad.isNotBlank()) { "La especialidad no puede estar vacía." }
    }
}
