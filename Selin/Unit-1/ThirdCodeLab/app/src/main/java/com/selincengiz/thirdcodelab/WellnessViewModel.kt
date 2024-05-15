package com.selincengiz.thirdcodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

//ViewModel rememberSaveable ile state tutamayacağımız
//durumlar için oldukça faydalıdır.
class WellnessViewModel: ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    //Gönderilen veri liste içinde bulunur.
    //null check yapılır.
    //daha sonrasında checked değeri değiştirilir.
    fun changeTaskChecked(item: WellnessTask, checked: Boolean) =
        _tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
}
//Örnek veri oluşturmak için bir fonksiyon
private fun getWellnessTasks() = List(30) { i ->
    WellnessTask(i, "Task #$i")
}