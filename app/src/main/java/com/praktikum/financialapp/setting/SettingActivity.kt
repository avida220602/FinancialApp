package com.praktikum.financialapp.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.praktikum.financialapp.R
import com.praktikum.financialapp.profile.ProfileActivity

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        title = "Menu Setting"
        val btnsave = findViewById<Button>(R.id.btnsimpan)
        val nama = findViewById<EditText>(R.id.etnamalkp)
        val nim = findViewById<EditText>(R.id.etnim)
        val mail = findViewById<EditText>(R.id.etemail)
        val nope = findViewById<EditText>(R.id.ethp)
        val pass = findViewById<EditText>(R.id.etpassword)
        val rgjk = findViewById<RadioGroup>(R.id.rgjenkel)
        val spiner = findViewById<Spinner>(R.id.spinner)
        val amcc = findViewById<CheckBox>(R.id.amcc)
        val hmmsi = findViewById<CheckBox>(R.id.himssi)
        val bem = findViewById<CheckBox>(R.id.bemamikom)
        val toggleButton = findViewById<ToggleButton>(R.id.togglebtn)

        btnsave.setOnClickListener {
            val cekjk = rgjk.checkedRadioButtonId
            val jk = findViewById<RadioButton>(cekjk)

            val org = StringBuilder()
            if (amcc.isChecked) {
                org.append("AMCC\n")
            }
            if (hmmsi.isChecked) {
                org.append("HMSSI\n")
            }
            if (bem.isChecked) {
                org.append("BEM AMIKOM\n")
            }

            val bundle = Bundle()
            bundle.putString("nama", nama.text.toString())
            bundle.putString("nim", nim.text.toString())
            bundle.putString("mail", mail.text.toString())
            bundle.putString("nope", nope.text.toString())
            bundle.putString("jkel", "${jk.text}")
            bundle.putString("prodi", spiner.selectedItem.toString())
            bundle.putString("org", org.toString())
            bundle.putString("status", toggleButton.text.toString())

            if (!Patterns.EMAIL_ADDRESS.matcher(mail.text.toString()).matches()) {
                mail.error = "Masukkan Email Dengan Benar"
            } else if (pass.length() == 0) {
                pass.error = "Password Tidak Boleh Kosong"
            } else {
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setTitle("Peringatan!!!!")
                alertDialogBuilder.setMessage("Apakah Data Anda Sudah Benar?")
                    .setCancelable(false)
                    .setPositiveButton(
                        "YES"
                    ) { dialogInterface, i ->
                        val intent = Intent(this, ProfileActivity::class.java)
                        intent.putExtras(bundle)
                        startActivity(intent)
                        Toast.makeText(this, "Data Profil Berhasil Tersimpan", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .setNegativeButton(
                        "NO"
                    ) { dialogInterface, i -> dialogInterface.cancel() }
                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()

            }
        }
    }
}