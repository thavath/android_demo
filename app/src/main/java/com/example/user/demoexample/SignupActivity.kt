package com.example.user.demoexample

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        var fullName = findViewById<EditText>(R.id.txtSfullname)
        var txtSemail = findViewById<EditText>(R.id.txtSemail)
        var txtSpassword= findViewById<EditText>(R.id.txtSpassword)
        var btnRegister = findViewById<Button>(R.id.btnRegister)
        var btnLogin = findViewById<Button>(R.id.btnSlogin)

        btnRegister.setOnClickListener{

            var username = fullName.text.toString()
            var email = txtSemail.text.toString()
            var password = txtSpassword.text.toString()

            if(!username.isEmpty() && !email.isEmpty() && !password.isEmpty()){
                var newuser = Person(username, email, password)
                var intent = Intent(this, MainActivity::class.java)
                intent.putExtra("newuser", newuser)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }else{
                Toast.makeText(this, "Please enter valid data !", Toast.LENGTH_SHORT).show()
            }
        }

        btnLogin.setOnClickListener {

            var intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

}
