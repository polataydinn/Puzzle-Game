package com.example.puzzlegame.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.puzzlegame.CardModel
import com.example.puzzlegame.databinding.CardItemBinding

class PuzzleGameAdapter(
    val onItemClickListener: (Int, CardModel) -> Unit
) :
    ListAdapter<CardModel, PuzzleGameViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PuzzleGameViewHolder {
        val binding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PuzzleGameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PuzzleGameViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClickListener)
    }

    class DiffCallback : DiffUtil.ItemCallback<CardModel>() {
        override fun areItemsTheSame(oldItem: CardModel, newItem: CardModel) =
            oldItem.id == newItem.id


        override fun areContentsTheSame(oldItem: CardModel, newItem: CardModel) =
            oldItem == newItem

    }
}