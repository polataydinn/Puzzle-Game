package com.example.puzzlegame.model

data class CardModel(
    val id: Int,
    val imagePath: Int,
    val isImageSelected: Boolean = false,
    val isImageMatched: Boolean = false,
    val isOpen: Boolean = false
)
