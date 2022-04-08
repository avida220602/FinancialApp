package com.praktikum.financialapp.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.praktikum.financialapp.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        title = "Menu Profile"
        val nama = findViewById<TextView>(R.id.tvnama)
        val nim = findViewById<TextView>(R.id.tvnim)
        val mail = findViewById<TextView>(R.id.tvemail)
        val nope = findViewById<TextView>(R.id.tvnohp)
        val jk = findViewById<TextView>(R.id.tvjk)
        val prodi = findViewById<TextView>(R.id.tvprogramstudi)
        val org = findViewById<TextView>(R.id.tvorganisasi)
        val status = findViewById<TextView>(R.id.tvstatus)

        val bukanbundle = intent.extras
        if (bukanbundle != null){
            nama.setText(bukanbundle.getString("nama"))
            nim.setText(bukanbundle.getString("nim"))
            mail.setText(bukanbundle.getString("mail"))
            nope.setText(bukanbundle.getString("nope"))
            jk.setText(bukanbundle.getString("jenkel"))
            prodi.setText(bukanbundle.getString("prodi"))
            org.setText(bukanbundle.getString("org"))
            status.setText(bukanbundle.getString("status"))
        }
    }
}



