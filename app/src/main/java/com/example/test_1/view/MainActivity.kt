package com.example.test_1.view

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.test_1.R
import com.example.test_1.ui.example1.ExampleFragment1
import com.example.test_1.ui.example2.ExampleFragment2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bai1: LinearLayout = findViewById(R.id.bai1)
        val bai2: LinearLayout = findViewById(R.id.bai2)

        bai1.setOnClickListener {
            replaceFragment(ExampleFragment1())
        }

        bai2.setOnClickListener {
            replaceFragment(ExampleFragment2())
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
