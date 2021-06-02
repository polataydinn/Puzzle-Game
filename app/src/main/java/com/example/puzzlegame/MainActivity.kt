package com.example.puzzlegame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.puzzlegame.fragments.StartGameFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startGameFragment = StartGameFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer,startGameFragment)
            .addToBackStack(StartGameFragment::class.simpleName)
            .commit()
    }
}


