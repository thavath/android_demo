package com.example.user.demoexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class SignupActivity : AppCompatActivity() {

    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("Users")
        mAuth = FirebaseAuth.getInstance()

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

                mAuth!!.createUserWithEmailAndPassword(email!!, password!!)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                val userId = mAuth!!.currentUser!!.uid
                                val currentUserDb = mDatabaseReference!!.child(userId)
                                currentUserDb.child("username").setValue(username)
                                Toast.makeText(this, "Authentication successful.",
                                        Toast.LENGTH_SHORT).show()
                                var intent = Intent(this, MainActivity::class.java)
                                intent.putExtra("newuser", newuser)
                                setResult(Activity.RESULT_OK, intent)
                                finish()
                            }else{
                                // to do
                                Toast.makeText(this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show()
                            }
                        }
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

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        // val currentUser = mAuth!!.getCurrentUser()
        // updateUI(currentUser)
    }

}
