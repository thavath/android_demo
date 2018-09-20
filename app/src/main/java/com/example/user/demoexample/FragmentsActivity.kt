package com.example.user.demoexample

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.LinearLayout
import com.example.user.demoexample.fragments.DemoFragment

import kotlinx.android.synthetic.main.activity_fragments.*

class FragmentsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)

        var btnBack = findViewById<Button>(R.id.btnBack)
        var btnNext = findViewById<Button>(R.id.btnNext)

        var demoFragment = DemoFragment()

        var container_fragment = findViewById<LinearLayout>(R.id.container_fragment)

        setFragment(demoFragment)

        btnNext.setOnClickListener {
            // container_fragment.setBackgroundResource(R.color.colorHbg)
            setFragment(demoFragment)
        }

    }

    private fun setFragment(fragment: DemoFragment) {

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.container_fragment, fragment)
        transaction.commit()

    }

}
