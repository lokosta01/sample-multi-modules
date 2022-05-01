package com.sample.featurea.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sample.featurea.presentation.components.VIEW_TYPE_HEADER
import com.sample.featurea.presentation.components.VIEW_TYPE_ITEM
import com.sample.featurea.presentation.components.PetCardItem
import com.sample.featurea.presentation.components.HeaderItem
import com.sample.featurea.presentation.components.PetItem
import com.sample.featurea.presentation.viewmodel.FeatureAViewModel
import com.sample.navigation.RoutConstants

@Composable
fun FeatureAScreen(navHostController: NavHostController) {

    val vm = hiltViewModel<FeatureAViewModel>()
    val marginSingle = 16.dp

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = marginSingle),
        verticalArrangement = Arrangement.spacedBy(marginSingle),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            items = vm.state
        ) { item ->
            when (item.type) {
                VIEW_TYPE_HEADER -> HeaderItem(item as PetItem.HeaderInfo)
                VIEW_TYPE_ITEM -> PetCardItem(item as PetItem.PetModel) { breed ->
                    navHostController.navigate("${RoutConstants.FEATURE_B}/$breed")
                }
            }
        }
    }
}

@Preview()
@Composable
fun ComposablePreview() {
    FeatureAScreen(rememberNavController())
}