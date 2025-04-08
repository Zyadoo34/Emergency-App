package com.example.emergenyapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val emergencies = arrayListOf<Emergency>()
        emergencies.add(Emergency(R.drawable.child, getString(R.string.child), "1600"))
        emergencies.add(Emergency(R.drawable.police_24, getString(R.string.police), "122"))
        emergencies.add(Emergency(R.drawable.fire, getString(R.string.fire), "180"))
        val adapter = EmergencyAdapter(this, emergencies)
        val rv: RecyclerView = findViewById(R.id.rv)
        rv.adapter = adapter



    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        val exit =ExitDialog()
        exit.isCancelable=false
        exit.show(supportFragmentManager,null)
    }
}