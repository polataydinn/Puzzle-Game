package com.example.puzzlegame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.puzzlegame.adapter.PuzzleGameAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    val cardList = arrayListOf<CardModel>()
    private lateinit var adapter: PuzzleGameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.idCourseRV);


        cardList.add(CardModel(1,R.drawable.polat))
        cardList.add(CardModel(2,R.drawable.abdulhey))
        cardList.add(CardModel(3,R.drawable.aslan))
        cardList.add(CardModel(4,R.drawable.duran))
        cardList.add(CardModel(5,R.drawable.elif))
        cardList.add(CardModel(6,R.drawable.erhan))
        cardList.add(CardModel(7,R.drawable.mehmet))
        cardList.add(CardModel(8,R.drawable.memati))
        cardList.add(CardModel(9,R.drawable.suleyman))
        cardList.add(CardModel(10,R.drawable.ziya))
        cardList.add(CardModel(1,R.drawable.polat))
        cardList.add(CardModel(2,R.drawable.abdulhey))
        cardList.add(CardModel(3,R.drawable.aslan))
        cardList.add(CardModel(4,R.drawable.duran))
        cardList.add(CardModel(5,R.drawable.elif))
        cardList.add(CardModel(6,R.drawable.erhan))
        cardList.add(CardModel(7,R.drawable.mehmet))
        cardList.add(CardModel(8,R.drawable.memati))
        cardList.add(CardModel(9,R.drawable.suleyman))
        cardList.add(CardModel(10,R.drawable.ziya))

        cardList.shuffle()

        adapter = PuzzleGameAdapter(cardList)

        val layoutManager = GridLayoutManager(this, 4)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter












    }
}


