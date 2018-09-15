package com.example.user.demoexample

import android.app.Fragment
import android.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.view.Menu
import android.view.View
import android.widget.FrameLayout
import com.google.android.gms.common.ErrorDialogFragment

class HomeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_detail)

        var mMainnav = findViewById<android.support.design.widget.BottomNavigationView>(R.id.main_nav)
        var mFrame = findViewById<FrameLayout>(R.id.frame_main)
        // var home = findViewById<View>(R.id.home_item)

        var homeFragment : HomeFragment = HomeFragment()
        var notificationFragment : NotificationFragment = NotificationFragment()
        var accountFragment : AccountFragment = AccountFragment()

        setFragment(homeFragment)

        mMainnav.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.home_item -> {
                    mMainnav.setItemBackgroundResource(R.color.colorPrimaryDark)
                    setFragment(homeFragment)
                    true
                }
                R.id.account_item -> {
                    mMainnav.setItemBackgroundResource(R.color.colorAccent)
                    setFragment(accountFragment)
                    true
                }
                R.id.notifi_item -> {
                    mMainnav.setItemBackgroundResource(R.color.colorBg)
                    setFragment(notificationFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun setFragment(fragment: HomeFragment) {

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.frame_main, fragment)
        transaction.commit()

    }
    private fun setFragment(fragment: NotificationFragment) {

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.frame_main, fragment)
        transaction.commit()

    }
    private fun setFragment(fragment: AccountFragment) {

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.frame_main, fragment)
        transaction.commit()

    }
}
