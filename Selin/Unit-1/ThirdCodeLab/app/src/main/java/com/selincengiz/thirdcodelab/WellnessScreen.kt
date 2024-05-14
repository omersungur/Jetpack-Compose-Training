package com.selincengiz.thirdcodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()
        //Listenin observable bir yapıya sahip olması için
        //mutable listeye çeviriyoruz, böylece onClose fonksiyonu ile
        //elemanı sildiğimizde liste otomatik olarak state'i güncelleyecek.
        //State'in güncellenmesi ise recomposition'ı tetikleyecek.
        //Fakat konfigürasyon değişiklikleri için bu sefer
        //rememberSaveable kullanılamamaktadır.Kullanıldığı takdirde
        //runtime exception fırlatılır çünkü rememberSaveable sadece
        //bundle içerisinde saklanabilen tipleri tutabilmektedir.
        //Bunu çözebilmek için state'i tutan bir viewmodel'a ihtiyacımız var.

        /*val list = remember { getWellnessTasks().toMutableStateList() }*/

        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task -> wellnessViewModel.remove(task) }
        )
    }

}

