package com.sample.featurea.presentation.components

const val VIEW_TYPE_HEADER = 0
const val VIEW_TYPE_ITEM = 1

sealed class PetItem(val type: Int) {
    data class PetModel(
        val name: String,
        val breed: String
    ): PetItem(VIEW_TYPE_ITEM)

    data class HeaderInfo(
        val title: String
    ): PetItem( VIEW_TYPE_HEADER)
}