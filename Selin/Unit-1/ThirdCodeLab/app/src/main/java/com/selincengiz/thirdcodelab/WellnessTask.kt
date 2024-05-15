package com.selincengiz.thirdcodelab

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

//State tutabilmek için checked kısmında MutableState'e gidilmiştir.
//Daha öncesinde rememberSaveable ile tutuluyordu.
//rememberSaveable yerine viewModel'a geçildi.
class WellnessTask(val id: Int, val label: String, initialChecked: Boolean = false) {
    var checked by mutableStateOf(initialChecked)
}
