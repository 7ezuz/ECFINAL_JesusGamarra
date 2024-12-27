package com.example.appgamarrajesus

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.appgamarrajesus.databinding.ActivityGamarraBinding
import com.example.appgamarrajesus.models.Alumno
import com.example.appgamarrajesus.models.AppDatabase
import kotlinx.coroutines.launch

class GamarraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGamarraBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGamarraBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "bdgamarrajesus"
        ).build()


        lifecycleScope.launch {
            if (db.alumnoDao().obtenerTodosLosAlumnos().isEmpty()) {
                db.alumnoDao().insertarAlumno(Alumno(0, "A001", "12345", "Miguel Rojas", "Derecho"))
                db.alumnoDao().insertarAlumno(Alumno(0, "A002", "54321", "Lucia Paz", "Medicina"))
                db.alumnoDao().insertarAlumno(Alumno(0, "A003", "09876", "Jesus Gamarra", "Ingeniería"))
            }
        }


        binding.btnIngresar.setOnClickListener {
            val codAlumno = binding.etCodAlumno.text.toString()
            val password = binding.etPassword.text.toString()


            lifecycleScope.launch {
                val alumno = db.alumnoDao().autenticarAlumno(codAlumno, password)
                if (alumno != null) {

                    val intent = Intent(this@GamarraActivity, DetalleActivity::class.java).apply {
                        putExtra("NOMBRE", alumno.nombreapellido)
                        putExtra("ESPECIALIDAD", alumno.especialidad)
                    }
                    startActivity(intent)
                } else {

                    binding.tvError.text = "Código o contraseña incorrectos"
                    binding.tvError.visibility = android.view.View.VISIBLE
                }
            }
        }
    }
}
