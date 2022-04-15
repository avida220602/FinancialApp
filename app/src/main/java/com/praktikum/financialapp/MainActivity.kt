package com.praktikum.financialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.praktikum.financialapp.ui.home.HomeFragment
import com.praktikum.financialapp.ui.profile.ProfileFragment
import com.praktikum.financialapp.ui.setting.SettingFragment

class MainActivity : AppCompatActivity() {

    private lateinit var btnHome : Button
    private lateinit var btnProfile : Button
    private lateinit var btnSetting : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHome = findViewById(R.id.btn_home)
        btnProfile = findViewById(R.id.btn_profile)
        btnSetting = findViewById(R.id.btn_setting)

//      btnHome.setOnClickListener {
//            val intent = Intent (this, HomeActivity::class.java)
//            intent.putExtra("username", "avida")
//            startActivity(intent)
//        }
//      btnProfile.setOnClickListener {
//            val intent = Intent (this, ProfileActivity::class.java)
//            startActivity(intent)
//          }
//      btnSetting.setOnClickListener {
//            val intent = Intent (this, SettingActivity  ::class.java)
//            startActivity(intent)
//          }

        btnHome.setOnClickListener {
            loadFragment(HomeFragment())
        }
        btnProfile.setOnClickListener {
            loadFragment(ProfileFragment())
        }
        btnSetting.setOnClickListener {
            loadFragment(SettingFragment())
        }
    }

    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }
}