package com.example.puzzlegame.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.puzzlegame.CardModel
import com.example.puzzlegame.R
import com.example.puzzlegame.databinding.CardItemBinding

class PuzzleGameViewHolder(private val binding: CardItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: CardModel,
        onItemClickListener: (Int) -> Unit
    ) {
        if (item.isOpen){
            binding.imageItem.setImageResource(item.imagePath)
        } else {
            binding.imageItem.setImageResource(R.drawable.kurtlar_vadisi)
        }
        binding.root.setOnClickListener {
            if (RecyclerView.NO_POSITION != bindingAdapterPosition) {
                onItemClickListener(bindingAdapterPosition)
            }
        }
    }
}
