package com.example.test_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.test_1.LoadJson.LoadFragment
import com.example.test_1.checkpointtriangle.TriangleFragment
import com.example.test_1.stringcount.StringCountFragment
import com.example.test_1.checktriangle.CheckTriangleFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.bai1 -> {
                    replaceFragment(StringCountFragment())
                    true
                }
                R.id.bai2 -> {
                    replaceFragment(CheckTriangleFragment())
                    true
                }
                R.id.bai3 -> {
                    replaceFragment(LoadFragment())
                    true
                }
                R.id.bai4 -> {
                    replaceFragment(TriangleFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
