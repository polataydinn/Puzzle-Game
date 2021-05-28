package com.example.puzzlegame.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.puzzlegame.CardModel
import com.example.puzzlegame.R

class PuzzleGameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var itemImage: ImageView? = null

    init {
        itemImage = itemView.findViewById(R.id.imageItem)
    }

    fun bind(item: CardModel) {
        var cardModel = item
      itemImage?.setImageResource(item.imagePath)
    }

}
