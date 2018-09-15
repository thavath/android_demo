package com.example.user.demoexample

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){


    var name = "rath thavath"
    var email = "thavath@gmail.com"
    var password = "thavath"


    var user = Person(name, email, password)
    var user1 = Person("admin", "admin@gmail.com", "admin5555")
    var users = ArrayList<Person>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        users.add(user)
        users.add(user1)


        var txtPassword = findViewById<EditText>(R.id.txtPassword)
        var txtEmail = findViewById<EditText>(R.id.txtEmail)
        var btnLogin = findViewById<Button>(R.id.btnLogin)
        var btnSignup = findViewById<TextView>(R.id.btnSignup)
        var btnSkip = findViewById<Button>(R.id.btnSkip)
        var btnHdtail = findViewById<Button>(R.id.btnHdetail)

        txtEmail.text.clear()
        txtPassword.text.clear()


        btnSkip.setOnClickListener {
            var intent = Intent(this, GalleryActivity::class.java)
            startActivity(intent)
        }

        btnHdtail.setOnClickListener {
            var intent = Intent(this, HomeDetailActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            if (txtEmail.text.isEmpty() && txtPassword.text.isEmpty()) {
                Toast.makeText(this, "Please input Email and Password", Toast.LENGTH_SHORT).show()
            }
            for (p in users) {
                if (p.dEmail.equals(txtEmail.text.toString()) && p.dPassword.equals(txtPassword.text.toString())) {
                    var intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("users", p)
                    Toast.makeText(this, "Log in successfully..", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                    finish()
                    break
                }else{
                    Toast.makeText(this, "Invalid User", Toast.LENGTH_SHORT).show()
                }
            }
        }
        btnSignup.setOnClickListener {

            var intent = Intent(this, SignupActivity::class.java)
            intent.putExtra("users" , users)
            startActivityForResult(intent, 5555)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            if(data != null){
                    var getnewuser = data.getSerializableExtra("newuser") as Person
                    users.add(getnewuser)
                    Toast.makeText(this, "Registered successfully please log in.", Toast.LENGTH_SHORT).show()
            }
        }
        else if(resultCode == Activity.RESULT_CANCELED){
                    Toast.makeText(this, "You back homepage.", Toast.LENGTH_SHORT).show()
            }
        }
}
