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


        cardList.add(CardModel(1,R.drawable.ic_launcher_background))
        cardList.add(CardModel(2,R.drawable.ic_launcher_background))
        cardList.add(CardModel(3,R.drawable.ic_launcher_background))
        cardList.add(CardModel(4,R.drawable.ic_launcher_background))
        cardList.add(CardModel(5,R.drawable.ic_launcher_background))
        cardList.add(CardModel(6,R.drawable.ic_launcher_background))
        cardList.add(CardModel(7,R.drawable.ic_launcher_background))
        cardList.add(CardModel(8,R.drawable.ic_launcher_background))
        cardList.add(CardModel(8,R.drawable.ic_launcher_background))
        cardList.add(CardModel(8,R.drawable.ic_launcher_background))
        cardList.add(CardModel(8,R.drawable.ic_launcher_background))
        cardList.add(CardModel(8,R.drawable.ic_launcher_background))
        cardList.add(CardModel(8,R.drawable.ic_launcher_background))
        cardList.add(CardModel(8,R.drawable.ic_launcher_background))
        cardList.add(CardModel(8,R.drawable.ic_launcher_background))
        cardList.add(CardModel(8,R.drawable.ic_launcher_background))
        cardList.add(CardModel(8,R.drawable.ic_launcher_background))
        cardList.add(CardModel(8,R.drawable.ic_launcher_background))
        cardList.add(CardModel(8,R.drawable.ic_launcher_background))
        cardList.add(CardModel(8,R.drawable.ic_launcher_background))

        adapter = PuzzleGameAdapter(cardList)

        val layoutManager = GridLayoutManager(this, 4)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter












    }
}


