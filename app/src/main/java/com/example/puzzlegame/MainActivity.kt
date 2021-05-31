package com.example.puzzlegame

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.idCourseRV);

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
            tempCardList.add(position)
            cardList[position].isOpen = true
            if (tempCardList.size == 2) {
                if (cardList[tempCardList[0]].id == cardList[tempCardList[1]].id) {
                    cardList[tempCardList[0]].isImageMatched = true
                    cardList[tempCardList[0]].isOpen = true
                    cardList[tempCardList[1]].isImageMatched = true
                    cardList[tempCardList[1]].isOpen = true
                } else {
                    cardList[position].isOpen = false
                    cardList[tempCardList[0]].isOpen = false
                }
                tempCardList.clear()
            }

            adapter.submitList(null)
            adapter.submitList(cardList)
        }
        adapter.submitList(cardList)
        val layoutManager = GridLayoutManager(this, 4)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

    }
}


