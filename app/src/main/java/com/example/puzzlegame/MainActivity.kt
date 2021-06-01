package com.example.puzzlegame

import android.annotation.SuppressLint
import android.graphics.Color.green
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.puzzlegame.adapter.PuzzleGameAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    val cardList = arrayListOf<CardModel>()
    val tempCardList = arrayListOf<Int>()
    val temp = arrayListOf<CardModel>()
    private lateinit var adapter: PuzzleGameAdapter
    private var score: Int = 0
    lateinit var restartButton: Button

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.idCourseRV);
        restartButton = findViewById(R.id.restartButton)

        cardList.apply {
            add(CardModel(1, R.drawable.polat))
            add(CardModel(2, R.drawable.abdulhey))
            add(CardModel(3, R.drawable.aslan))
            add(CardModel(4, R.drawable.duran))
            add(CardModel(5, R.drawable.elif))
            add(CardModel(6, R.drawable.erhan))
            add(CardModel(7, R.drawable.mehmet))
            add(CardModel(8, R.drawable.memati))
            add(CardModel(9, R.drawable.suleyman))
            add(CardModel(10, R.drawable.ziya))
            add(CardModel(1, R.drawable.polat))
            add(CardModel(2, R.drawable.abdulhey))
            add(CardModel(3, R.drawable.aslan))
            add(CardModel(4, R.drawable.duran))
            add(CardModel(5, R.drawable.elif))
            add(CardModel(6, R.drawable.erhan))
            add(CardModel(7, R.drawable.mehmet))
            add(CardModel(8, R.drawable.memati))
            add(CardModel(9, R.drawable.suleyman))
            add(CardModel(10, R.drawable.ziya))
        }
        cardList.shuffle()

        adapter = PuzzleGameAdapter { position ->
            if (score >= 0 && score < 10){
                tempCardList.add(position)
                cardList[position].isOpen = true
                Handler(Looper.getMainLooper()).postDelayed(Runnable {
                    if (tempCardList.size == 2) {
                        if (cardList[tempCardList[0]].id == cardList[tempCardList[1]].id) {
                            cardList[tempCardList[0]].isImageMatched = true
                            cardList[tempCardList[0]].isOpen = true
                            cardList[tempCardList[1]].isImageMatched = true
                            cardList[tempCardList[1]].isOpen = true
                            score += 1
                            if(score == 10){
                                Toast.makeText(this, "Tebrikler Kazandınız", Toast.LENGTH_SHORT).show()
                                restartButton.background.setTint(R.color.green)
                            }
                        } else {
                            cardList[position].isOpen = false
                            cardList[tempCardList[0]].isOpen = false
                        }
                        tempCardList.clear()

                    }
                }, 10)
                adapter.submitList(null)
                adapter.submitList(cardList)
            }
            
        }
        
        restartButton.setOnClickListener(View.OnClickListener { 
            if (score == 10){
                Toast.makeText(this, "button çalışıyor", Toast.LENGTH_SHORT).show()
            }
        })

        adapter.submitList(cardList)
        val layoutManager = GridLayoutManager(this, 4)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

    }
}


