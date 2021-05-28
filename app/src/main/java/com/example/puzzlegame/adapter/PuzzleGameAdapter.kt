package com.example.puzzlegame.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.puzzlegame.CardModel
import com.example.puzzlegame.R

class PuzzleGameAdapter(var itemList :  List<CardModel>) : RecyclerView.Adapter<PuzzleGameViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PuzzleGameViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.card_item, parent, false)
        return PuzzleGameViewHolder(view)
    }

    override fun onBindViewHolder(holder: PuzzleGameViewHolder, position: Int) {
        holder.itemView.rootView.setOnClickListener(View.OnClickListener {
            holder.bind(itemList[position])
        })
    }

    override fun getItemCount() = itemList.size
}