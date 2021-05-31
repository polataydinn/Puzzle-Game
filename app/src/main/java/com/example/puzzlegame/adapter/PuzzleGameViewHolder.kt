package com.example.puzzlegame.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.puzzlegame.CardModel
import com.example.puzzlegame.databinding.CardItemBinding

class PuzzleGameViewHolder(private val binding: CardItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: CardModel,
        onItemClickListener: (Int, CardModel) -> Unit
    ) {

        binding.root.setOnClickListener {
            if (RecyclerView.NO_POSITION != bindingAdapterPosition)
                onItemClickListener(bindingAdapterPosition, item)
        }
    }
}
