package com.example.appgamarrajesus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appgamarrajesus.databinding.ActivityDetalleBinding

class DetalleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Vincular ViewBinding
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener los datos enviados desde GamarraActivity
        val nombre = intent.getStringExtra("NOMBRE")
        val especialidad = intent.getStringExtra("ESPECIALIDAD")

        // Mostrar los datos en la UI
        binding.tvNombre.text = nombre
        binding.tvEspecialidad.text = especialidad
        binding.btnRegresar.setOnClickListener {
            finish()
        }

    }
}
