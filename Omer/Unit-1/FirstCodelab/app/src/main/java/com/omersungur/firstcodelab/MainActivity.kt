package com.omersungur.firstcodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omersungur.firstcodelab.ui.theme.FirstCodelabTheme

/**
 * Chapter - 3
 */

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            FirstCodelabTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting(name = "Kotlin")
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
///**
// * Preview notasyonu ile bu composable'ın ön izlemesini görebiliyoruz.
// */
//@Preview(showBackground = true, name = "Text preview")
//@Composable
//fun GreetingPreview() {
//    FirstCodelabTheme {
//        Greeting(name = "Android")
//    }
//}

/**
 * Chapter - 4
 */

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            FirstCodelabTheme {
//                Surface(
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting(name = "Kotlin")
//                }
//            }
//        }
//    }
//}
//
///**
// * Text'i bir Surface içine alıyoruz. Surface'ın color parametresiyle beraber UI rengini değiştirdik.
// *
// * Surface içinde bulunan componentler bu yüzeyin üstüne çizilir. Burada ilginç olan şey, biz sadece surface rengini değiştirdik
// * fakat Text'in rengini de değişti. Bunu surface component'i, daha iyi bir kullanıcı deneyimi için kendi sağlıyor.
// */
////@Composable
////fun Greeting(name: String, modifier: Modifier = Modifier) {
////    Surface(color = MaterialTheme.colorScheme.primary) {
////        Text(
////            text = "Hello $name!",
////            modifier = modifier
////        )
////    }
////}
//
///**
// * Modifier, bir kullanıcı arayüzü öğesine ana düzeninde nasıl yerleştirileceğini, görüntüleneceğini veya davranacağını söyler.
// *
// * Buradaki padding vererek bu Text'in her yerden 24 dp'lik boşluk bırakmasını sağlıyoruz.
// */
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Surface(color = MaterialTheme.colorScheme.primary) {
//        Text(
//            text = "Hello $name!",
//            modifier = modifier.padding(24.dp)
//        )
//    }
//}

/**
 * Chapter - 5
 */

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            FirstCodelabTheme {
//                MyApp(modifier = Modifier.fillMaxWidth())
//            }
//        }
//    }
//}
//
///**
// * Her UI elementini iç içe yazmak kod okunaklığını azaltır bu yüzden UI'ları küçük composable fonksiyonlarına bölerek
// * tekrar tekrar kullanmak daha iyidir. Clean code!
// *
// * Best practice olarak bir composable fonksiyonunda default olarak modifier olması iyidir.
// * Daha sonradan başka bir yerde modifiye etmek isteyebiliriz.
// */
//
///**
// * Garip bir deneme olarak, aşağıdaki Greeting fonksiyonununun modifier'ını çağırıp padding verirsek, Greeting fonksiyonunun içindeki
// * padding ile birleşerek bir padding oluşuyor...
// */
//@Composable
//fun MyApp(modifier: Modifier = Modifier) {
//    Surface(
//        modifier = modifier,
//        color = MaterialTheme.colorScheme.background
//    ) {
//        Greeting("Android")
//        // Greeting("Android", modifier = Modifier.padding(16.dp))
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Surface(color = MaterialTheme.colorScheme.primary) {
//        Text(
//            text = "Hello $name!",
//            modifier = modifier.padding(24.dp)
//        )
//    }
//}

/**
 * Chapter - 6
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstCodelabTheme {
                MyApp(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}
@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose")
) {
    // Direkt olarak statüs bar ile bu yapının arasındaki padding.
    Column(modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        // Yazı ile içindeki container arasındaki padding
        Column(modifier = modifier.padding(24.dp)) {
            Text(text = "Hello ")
            Text(text = name)
        }
    }
}

/**
 * Weight, öğenin mevcut tüm alanı doldurmasını sağlayarak onu esnek hale getirir ve esnek olmayan olarak
 * adlandırılan, ağırlığı olmayan diğer öğeleri etkili bir şekilde iter. Ayrıca fillMaxWidth değiştiricisini gereksiz hale getirir.
 *
 * Eğer composable içindeki datalar değişirse yeni datalarla beraber yeni UI çizilir. Buna recomposition denir. Sadece etkilenen UI
 * parçaları tekrardan çizilir. Etkilenmeyenler aynısı gibi kalır.
 *
 * Eğer bir değere göre UI yeniden çizdirilecekse bunu mutableStateOf ile tutmalıyız ki Compose takip etsin. Eğer normal olarak tanımlarsak
 * Greeting fonksiyonu her çağrıldığında içindeki state sıfırlanacak.
 *
 * State ve MutableState değer tutan ve değer değiştiğinde UI'ın güncellenmesi için tetikleme yapan interface yapılarıdır.
 * Composable fonksiyonlar herhangi bir zamanda recomposition'a uğrayabilir. remember keywordünü, composable fonksiyon yeniden
 * oluşturulurken o state'i kaybetmemek için kullanıyoruz.
 *
 * Aynı composable'ı ekranın farklı bölümlerinden çağırırsanız, her biri kendi durum sürümüne sahip farklı UI öğeleri oluşturacağınızı
 * unutmayın. Dahili durumu bir sınıftaki özel bir değişken olarak düşünebilirsiniz.
 */
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    // var expanded = false // Bu şekilde kullanım yapmamalıyız. Compose'un bunu bir durum değişikliği olarak algılamasını sağlamaz, bu nedenle hiçbir şey olmaz.
//    val expanded = remember { mutableStateOf(false) }
//    val extraPadding = if (expanded.value) 48.dp else 0.dp
//    Surface(
//        color = MaterialTheme.colorScheme.primary,
//        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//    ) {
//        Row(modifier = Modifier.padding(24.dp)) {
//            Column(modifier = Modifier
//                .weight(1f)
//                .padding(bottom = extraPadding)) {
//                Text(text = "Hello ")
//                Text(text = name)
//            }
//            ElevatedButton(
//                onClick = {
//                    expanded.value = !expanded.value
//                }
//            ) {
//                if (expanded.value) Text("Show more") else Text(text = "OK")
//            }
//        }
//    }
//}

/**
 * State hoisting: Composable fonksiyonlarda stateler birden fazla yerde okunuyorsa veya değiştiriliyorsa bunlar,
 * olabildiğince hiyerarşideki en üst yapılara taşınmalı. Bu şekilde bir state'den birden çok tanımlamayız, daha az bugla karşılaşırız ve
 * composable, tekrar tekrar kullanılabilir hale gelir. Ek olarak test yazma işini de kolaylaştırır.
 */

//@Composable
//fun MyApp(modifier: Modifier = Modifier) {
//
//    var shouldShowOnboarding by remember { mutableStateOf(true) }
//
//    Surface(modifier) {
//        if (shouldShowOnboarding) {
//            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
//        } else {
//            Greetings()
//        }
//    }
//}
//
//@Composable
//fun OnboardingScreen(
//    onContinueClicked: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    Column(
//        modifier = modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Welcome to the Basics Codelab!")
//        Button(
//            modifier = Modifier.padding(vertical = 24.dp),
//            onClick = onContinueClicked
//        ) {
//            Text("Continue")
//        }
//    }
//}
//
////@Composable
////private fun Greetings(
////    modifier: Modifier = Modifier,
////    names: List<String> = listOf("World", "Compose")
////) {
////    Column(modifier = modifier.padding(vertical = 4.dp)) {
////        for (name in names) {
////            Greeting(name = name)
////        }
////    }
////}
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//
//    var expanded by remember { mutableStateOf(false) }
//
//    val extraPadding = if (expanded) 48.dp else 0.dp
//
//    Surface(
//        color = MaterialTheme.colorScheme.primary,
//        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//    ) {
//        Row(modifier = Modifier.padding(24.dp)) {
//            Column(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(bottom = extraPadding)
//            ) {
//                Text(text = "Hello, ")
//                Text(text = name)
//            }
//            ElevatedButton(
//                onClick = { expanded = !expanded }
//            ) {
//                Text(if (expanded) "Show less" else "Show more")
//            }
//        }
//    }
//}
//
//@Composable
//private fun Greetings(
//    modifier: Modifier = Modifier,
//    names: List<String> = List(1000) { "$it" }
//) {
//    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
//        items(items = names) { name ->
//            Greeting(name = name)
//        }
//    }
//}
//
