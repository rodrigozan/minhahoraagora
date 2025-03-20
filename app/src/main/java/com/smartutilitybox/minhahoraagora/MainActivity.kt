package com.smartutilitybox.minhahoraagora

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var horaTextView: TextView
    private val handler = Handler(Looper.getMainLooper())
    private val formatoHora = SimpleDateFormat("HH:mm:ss", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        horaTextView = findViewById(R.id.horaTextView)
        atualizarHora()
    }

    private fun atualizarHora() {
        handler.post(object : Runnable {
            override fun run() {
                val horaAtual = formatoHora.format(Date())
                horaTextView.text = horaAtual
                handler.postDelayed(this, 1000)
            }
        })
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}
