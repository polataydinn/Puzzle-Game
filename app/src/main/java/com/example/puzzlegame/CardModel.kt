package com.example.puzzlegame

data class CardModel(
    val id: Int,
    val imagePath: Int,
    var isImageSelected: Boolean = false,
    var isImageMatched: Boolean = false,
    var isOpen: Boolean = false
)
