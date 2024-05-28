package com.omersungur.thirdcodelab

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.omersungur.thirdcodelab.ui.WellnessViewModel
import com.omersungur.thirdcodelab.ui.theme.ThirdCodelabTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThirdCodelabTheme {
                Scaffold(modifier =
                Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                    .navigationBarsPadding()
                ) {
                    WellnessScreen()
                }
            }
        }
    }
}

/**
 * State, herhangi bir zamanda kullanıcı arayüzünde neyin gösterileceğini belirler. Çok geniş
 * bir tanım yapılabilir.
 *
 * Peki bu stateler nasıl güncellenir? Bir event yani bir olay olduğu zaman olur. Örneğin bir butona tıkladık,
 * veya bir yerlere bir şeyler yazdık. Kısacası bir tetikleme olduğunuda değişebilir.
 * Bu tetikleme dışarıdan da yapılabilir.
 *
 * State'ler UI'da gösterilen durumlarken, Eventler state'lerin değiştiği
 * ve UI'da değişikliklere neden olan mekanizmadır. State vardır. Event gerçekleşir :)
 *
 * Bütün olay eventler ve stateler arasındaki durumdur. Bir event olur bu state'i değiştirir ve UI'da bu state'i görürüz.
 */

/**
 * Buradaki count değişkeninin hiçbir şekilde ekrana yansımadığını görürüz. Neden? Çünkü buradaki count değişkeninin
 * bir state olduğunu composable fonksiyonuna söylemedik.
 */

//@Composable
//fun WaterCounter(modifier: Modifier = Modifier) {
//    Column(modifier = modifier.padding(16.dp)) {
//        var count = 0
//        Text("You've had $count glasses.")
//        Button(onClick = { count++ }, Modifier.padding(top = 8.dp)) {
//            Text("Add one")
//        }
//    }
//}

/**
 * Bir composable fonksiyon içindeki state değişirse bu fonksiyon recomposition'a uğrar. Yeni state'le beraber
 * UI tekrardan çizilir. Sadece state'i değişen fonksiyonlar UI'da güncellenir.
 *
 * Compose, stateleri sadece değiştirmez aynı zamanda okuyarak takip eder. Bu sayede sadece değişen stateleri
 * belirleyerek onlara özel render işlemi yapar.
 *
 * Composition: Bir UI'ı oluşturmak için birden fazla composable fonksiyonu bir araya getirme işlemidir. Composition,
 * composable fonksiyonları hiyerarşik bir şekilde düzenleyerek ve birbirleriyle ilişkilendirerek gerçekleştirilir.
 *
 * Stateleri takip edebilmek için State ve MutableState'i kullanırız. Bunlar gözlemci yapılarıdır.
 * mutableStateOf'u kullanarak state'i takip ettirebiliriz. Bunun dışında mutableIntStateOf gibi
 * primitive typelara özel optimazsyon sağlayan yapılarda vardır.
 *
 * Fakat burada bir sıkıntı var. remember kullanmazsak her recomposition'da count state'i sıfırlanacaktır.
 *
 * Normalde LiveData, Flow, StateFlow yapılarını kullanırdık. Compose'un otomatik recomposition yapması için
 * bunları State içine almalıyız.
 */

//@Composable
//fun WaterCounter(modifier: Modifier = Modifier) {
//    Column(modifier = modifier.padding(16.dp)) {
//        val count: MutableState<Int> = remember { mutableStateOf(0) }
//        //val count by remember { mutableStateOf(0) } // Burada .value diyerek erişmemize gerek kalmıyor.
//
//        Text("You've had ${count.value} glasses.")
//        Button(onClick = { count.value++ }, Modifier.padding(top = 8.dp)) {
//            Text("Add one")
//        }
//    }
//}
//
//@Composable
//fun WellnessScreen(modifier: Modifier = Modifier) {
//    WaterCounter(modifier)
//}

//@Composable
//fun WellnessTaskItem(
//    taskName: String,
//    onClose: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    Row(
//        modifier = modifier, verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(
//            modifier = Modifier
//                .weight(1f)
//                .padding(start = 16.dp),
//            text = taskName
//        )
//        IconButton(onClick = onClose) {
//            Icon(Icons.Filled.Close, contentDescription = "Close")
//        }
//    }
//}

/**
 * Compose'da bir şeyleri visible ya da hide olarak ayarlamayız. Bir şeyi göstermeyeceksek logic kurarız (if gibi). Stateler sürekli okunup takip
 * edildiği için bir değişiklik olduğunda recomposition olur ve logic kısım nasılsa öyle bir değişiklik olur. Aşağıda showTask eğer false
 * ise onun içinde bulunan composable fonksiyonlarını göstermeyiz.
 *
 * config ayarları değiştiğinde bile stateleri hatırlamak istiyorsam remember yerine rememberSaveable kullanabiliriz.
 */

//@Composable
//fun WaterCounter(modifier: Modifier = Modifier) {
//    Column(modifier = modifier.padding(16.dp)) {
//        var count by remember { mutableStateOf(0) }
//        if (count > 0) {
//            var showTask by remember { mutableStateOf(true) }
//            if (showTask) {
//                WellnessTaskItem(
//                    onClose = { showTask = false },
//                    taskName = "Have you taken your 15 minute walk today?"
//                )
//            }
//            Text("You've had $count glasses.")
//        }
//
//        Row(Modifier.padding(top = 8.dp)) {
//            Button(onClick = { count++ }, enabled = count < 10) {
//                Text("Add one")
//            }
//            Button(
//                onClick = { count = 0 },
//                Modifier.padding(start = 8.dp)) {
//                Text("Clear water count")
//            }
//        }
//    }
//}

/**
 * State Hoisting
 *
 * Bir composable fonksiyonu içerisinde remember ile state tutuyorsa o composable fonksiyonu stateful'dur. Bu composable'ı çağırırken bir şey yapmayız,
 * kontrol composable içinde olur. Bu açıdan yararlı olsa da bu bazı şeyleri zorlaştırır. Composable'ın yeniden kullanımı ve test edilmesi zorlaşır.
 *
 * Stateless bir composable oluşturmanın en kolay yolu state hoisting paternini kullanmaktır.
 *
 * Unidirectional Data Flow: Statelerin aşağı, eventlerin yukarı aktığı bir design paterndir. State hoisting, bu design pattern'i nasıl
 * implement edeceğimizdir.
 *
 * State hoisting faydaları:
 *
 * Single source of truth: Birden fazla duplicate state kullanmaktansa state'i yukarı kaldırdığımız için tek bir kaynağı olacak. Bu bugları
 * ve hataları azaltır.
 *
 * Shareable: State hoisting ile bir state'i birden fazla composable içinde kullanabiliriz.
 *
 * Interceptable: Stateless composable fonksiyonları çağıran yapılar state değişmeden önce eventleri değiştirebilir veya iptal edebilir.
 * Bu da daha müdahale edebilir olmasını sağlar.
 *
 * Decoupled: Stateless composable fonksiyonlar için stateler her yerde saklanabilir. Bu da ayrıştırmayı sağlar. ViewModel vs.
 *
 * State Hoisting Yaparken Önemli Noktalar:
 *
 * - State, olabildiğince ortak olmayan parent'a yükseltilmelidir (okuma).
 *
 * - State, en çok değiştirilebileceği yere yükseltilmelidir (yazma).
 *
 * - Eğer iki state aynı eventlere tepki olarak değişiyorsa, aynı seviyeye yükseltilmelidirler.
 */
@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, { count++ }, modifier)
}

//@Composable
//fun StatefulCounter() {
//    var waterCount by remember { mutableStateOf(0) }
//
//    var juiceCount by remember { mutableStateOf(0) }
//
//    StatelessCounter(waterCount, { waterCount++ })
//    StatelessCounter(juiceCount, { juiceCount++ })
//}
//
//@Composable
//fun WellnessScreen(modifier: Modifier = Modifier) {
//    StatefulCounter(modifier)
//}

//@Composable
//fun WellnessTaskItem(
//    taskName: String,
//    checked: Boolean,
//    onCheckedChange: (Boolean) -> Unit,
//    onClose: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    Row(
//        modifier = modifier, verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(
//            modifier = Modifier
//                .weight(1f)
//                .padding(start = 16.dp),
//            text = taskName
//        )
//        Checkbox(
//            checked = checked,
//            onCheckedChange = onCheckedChange
//        )
//        IconButton(onClick = onClose) {
//            Icon(Icons.Filled.Close, contentDescription = "Close")
//        }
//    }
//}

//@Composable
//fun WellnessTaskItem(
//    taskName: String, onClose: () -> Unit, modifier: Modifier = Modifier
//) {
//    var checkedState by rememberSaveable { mutableStateOf(false) }
//
//    WellnessTaskItem(
//        taskName = taskName,
//        checked = checkedState,
//        onCheckedChange = { newValue -> checkedState = newValue },
//        onClose = onClose,
//        modifier = modifier,
//    )
//}

// data class WellnessTask(val id: Int, val label: String)

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

//@Composable
//fun WellnessTasksList(
//    list: List<WellnessTask>,
//    onCloseTask: (WellnessTask) -> Unit,
//    modifier: Modifier = Modifier
//) {
//    LazyColumn(modifier = modifier) {
//        items(
//            items = list,
//            key = { task -> task.id }
//        ) { task ->
//            WellnessTaskItem(taskName = task.label, onClose = { onCloseTask(task) })
//        }
//    }
//}

/**
 * Compose'un stateleri takip edebilmesi için mutableList değil mutableStateList'i kullanıyoruz. Çünkü bu bir observable type.
 *
 * Fakat şöyle bir kullanım yapmak performans kaybına sebebiyet verebilir. Çünkü her eleman eklendiğinde recomposition olur.
 *
 * val list = remember { mutableStateListOf<WellnessTask>() }
 * list.addAll(getWellnessTasks())
 *
 * Bunun yerine şunu kullanmalıyız:
 *
 * val list = remember {
 *
 * mutableStateListOf<WellnessTask>().apply { addAll(getWellnessTasks()) }
 *
 * }
 */

//@Composable
//fun WellnessScreen(modifier: Modifier = Modifier) {
//    Column(modifier = modifier) {
//        StatefulCounter()
//
//        val list = remember { getWellnessTasks().toMutableStateList() } // Burada rememberSaveable  kullanılamaz. Uygulama çöker.
//        // Sebebi ise rememberSaveable Bundle içinde saklanabilen veri türlerini tutabiliyor. (örneğin, primitive türler, String, Parcelable)
//        // Bunu için custom saver kullanabiliriz.
//        WellnessTasksList(list = list, onCloseTask = { task -> list.remove(task) })
//    }
//}

/**
 * UI Logic: Stateler değiştiğinde ekranda ne gözükeceğidir.
 *
 * Business Logic: State değiştiğinde ne olacağıdır.
 *
 * View Model entegre ediyoruz...
 */

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()

        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task ->
                wellnessViewModel.remove(task)
            }
        )
    }
}

@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked -> onCheckedTask(task, checked) },
                onClose = { onCloseTask(task) }
            )
        }
    }
}

@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskName
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

//data class WellnessTask(val id: Int, val label: String, var checked: Boolean = false)

class WellnessTask(
    val id: Int,
    val label: String,
    initialChecked: Boolean = false
) {
    var checked by mutableStateOf(initialChecked)
}
