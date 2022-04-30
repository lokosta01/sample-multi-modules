package com.sample.featurea.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalUnitApi::class)
@Composable
fun PetCardItem(
    state: PetItem.PetModel,
    onItemClick: (breed: String) -> Unit
) {
    Card(elevation = 20.dp) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .clickable { onItemClick.invoke(state.breed) },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = state.name,
                fontSize = TextUnit(16F, TextUnitType.Sp),
                color = Color.Black
            )
            Text(
                text = state.breed,
                fontSize = TextUnit(16F, TextUnitType.Sp),
                color = Color.Gray
            )
        }
    }
}