package com.selincengiz.thirdcodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

//recompositon sonrası listenin hatırlanması için
//remember bloğu içerisinde tanımlıyoruz.
//onCloseTask ile state hoisting yapılır.
//Liste içerisindeki eleman üst katmana gönderilmektedir.
@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    //Lazy column'un rememberLazyListState özelliği vardır ve bu özellik
    //activite tekrar oluşturulduğunda scroll state'inin hatırlanmasını sağlar
    //items yöntemi bir key parametresi alır. Varsayılan olarak, her öğenin durumu,
    //öğenin listedeki konumuyla eşleştirilip anahtarlanır.
    //Değişken bir listede, bu, veri seti değiştiğinde sorunlara yol açar,
    //çünkü konumu değişen öğeler etkili olarak herhangi bir hatırlanan durumu kaybeder.
    //Bu sorunu kolayca her WellnessTaskItem'ın kimliğini
    //her öğenin anahtarı olarak kullanarak düzeltebilirsiniz.
    LazyColumn(modifier = modifier) {
        items(items = list, key = { task -> task.id }) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked -> onCheckedTask(task, checked) },
                onClose = { onCloseTask(task) }
            )
        }
    }
}

