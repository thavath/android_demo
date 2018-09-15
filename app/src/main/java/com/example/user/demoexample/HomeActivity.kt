package com.example.user.demoexample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var users = intent.getSerializableExtra("users") as Person

        var username = findViewById<TextView>(R.id.lblHname)
        var useremail = findViewById<TextView>(R.id.lblHemail)

        var btnLogout= findViewById<Button>(R.id.btnLogout)

        username.text = users.dName
        useremail.text = users.dEmail

        btnLogout.setOnClickListener{

            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
