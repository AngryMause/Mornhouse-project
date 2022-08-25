package com.example.mornhouseproject.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mornhouseproject.databinding.ActivityMainBinding
import com.example.mornhouseproject.ui.fragment.mainscreens.MainFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.mainContainer.id, MainFragment.newInstance()).commit()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null!!
    }
}