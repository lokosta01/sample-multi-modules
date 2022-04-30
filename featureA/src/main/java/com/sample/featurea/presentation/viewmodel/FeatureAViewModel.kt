package com.sample.featurea.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.sample.featurea.presentation.components.PetItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeatureAViewModel @Inject constructor(): ViewModel() {

    val state = mutableListOf(
        PetItem.HeaderInfo("all pets"),
        PetItem.PetModel("Kate", "cat"),
        PetItem.PetModel("Tuzik", "dog")
    )
}