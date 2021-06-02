package com.example.puzzlegame

import android.annotation.SuppressLint
import android.content.Intent
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
    private var isGameStarted: Boolean = false


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.idCourseRV);
        restartButton = findViewById(R.id.restartButton)

        initContent()

        adapter = PuzzleGameAdapter { position ->
            if (!isGameStarted) {
                cardList[position] = cardList[position].copy(isOpen = true)
                adapter.submitList(null)
                adapter.submitList(cardList.toList())
                isGameStarted = true
            } else {
                if ((score >= 0 || score < 10)) {
                    if (!(cardList[position].isOpen && cardList[position].isImageMatched)) {
                        cardList[position] = cardList[position].copy(isOpen = true)
                        val indexList = cardList
                            .filter { (it.isOpen || (it.id == cardList[position].id)) && !it.isImageMatched }
                            .map { cardList.indexOf(it) }

                        Handler(Looper.getMainLooper()).postDelayed({
                            if (indexList.size == 2) {
                                if (cardList[indexList[0]].imagePath == cardList[indexList[1]].imagePath) {
                                    cardList[indexList[0]] = cardList[indexList[0]].copy(
                                        isOpen = true,
                                        isImageMatched = true
                                    )
                                    cardList[indexList[1]] = cardList[indexList[1]].copy(
                                        isOpen = true,
                                        isImageMatched = true
                                    )
                                    score += 1
                                    if (score == 10) {
                                        restartButton.background.setTint(R.color.green)

                                    }
                                } else {
                                    cardList[indexList[0]] = cardList[indexList[0]].copy(
                                        isOpen = false,
                                        isImageMatched = false
                                    )
                                    cardList[indexList[1]] = cardList[indexList[1]].copy(
                                        isOpen = false,
                                        isImageMatched = false
                                    )
                                }
                            } else {
                                cardList[indexList[0]] = cardList[indexList[0]].copy(
                                    isOpen = true,
                                    isImageMatched = false
                                )
                            }
                        }, 10)
                        adapter.submitList(cardList.toList())
                    }
                }
            }
        }



        restartButton.setOnClickListener(View.OnClickListener {
            if (score == 10) {
                Toast.makeText(this, "button çalışıyor", Toast.LENGTH_SHORT).show()
                val intent: Intent = getIntent()
                finish()
                startActivity(intent)
            }
        })

        adapter.submitList(cardList)
        val layoutManager = GridLayoutManager(this, 4)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

    }

    private fun initContent() {
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
            add(CardModel(11, R.drawable.polat))
            add(CardModel(12, R.drawable.abdulhey))
            add(CardModel(13, R.drawable.aslan))
            add(CardModel(14, R.drawable.duran))
            add(CardModel(15, R.drawable.elif))
            add(CardModel(16, R.drawable.erhan))
            add(CardModel(17, R.drawable.mehmet))
            add(CardModel(18, R.drawable.memati))
            add(CardModel(19, R.drawable.suleyman))
            add(CardModel(20, R.drawable.ziya))
        }
        cardList.shuffle()
    }
}


