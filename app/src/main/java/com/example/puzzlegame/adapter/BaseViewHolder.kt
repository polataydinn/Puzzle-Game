package com.example.puzzlegame.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.puzzlegame.model.CardModel

class BaseViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent) {

    fun bind(cardModel: CardModel, position: Int, onItemClickListener: (Int) -> Unit) {

    }

}