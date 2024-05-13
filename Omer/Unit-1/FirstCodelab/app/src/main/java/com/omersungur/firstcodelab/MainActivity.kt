package com.omersungur.firstcodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
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
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omersungur.firstcodelab.ui.theme.FirstCodelabTheme

/**
 * Chapter - 3 -> Getting started with Compose
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
 * Chapter - 4 -> Tweaking the UI
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
 * Chapter - 5 -> Reusing composables
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
 * Chapter - 6 -> Creating columns and rows
 */

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            FirstCodelabTheme {
//                MyApp()
//            }
//        }
//    }
//}
//
//@Composable
//fun MyApp(
//    modifier: Modifier = Modifier,
//    names: List<String> = listOf("World", "Compose", "Android")
//) {
//    // Buradaki padding app kenarları ile 16 dp boşluk bırakır
//    Column(modifier = modifier.padding(16.dp)) {
//        for (name in names) {
//            Greeting(name = name)
//        }
//    }
//}
//
///**
// * Buradaki Text default olarak sadece kapladığı alan kadar genişler. Bu kaplanan alanı modifier ile ayarlayabilriz.
// */
////@Composable
////fun Greeting(name: String, modifier: Modifier = Modifier) {
////    Surface(color = MaterialTheme.colorScheme.primary,
////    ) {
////        // Yazı ile içindeki container arasındaki padding
////        Column(modifier = modifier.padding(24.dp)) {
////            Text(text = "Hello ")
////            Text(text = name)
////        }
////    }
////}
//
///**
// * fillMaxWidth, ekranı yatay olarak tamamen kaplar.
// */
////@Composable
////fun Greeting(name: String, modifier: Modifier = Modifier) {
////    Surface(
////        color = MaterialTheme.colorScheme.primary,
////    ) {
////        // Yazı ile içindeki container arasındaki padding
////        Column(modifier = modifier.fillMaxWidth().padding(24.dp)) {
////            Text(text = "Hello ")
////            Text(text = name)
////        }
////    }
////}
//
///**
// * Buton Oluşturma:
// *
// * Weight, öğenin mevcut tüm alanı doldurmasını sağlayarak onu esnek hale getirir ve esnek olmayan olarak
// * adlandırılan, ağırlığı olmayan diğer öğeleri etkili bir şekilde iter. Ayrıca fillMaxWidth değiştiricisini gereksiz hale getirir.
// *
// * Eğer composable içindeki datalar değişirse yeni datalarla beraber yeni UI çizilir. Buna recomposition denir. Sadece etkilenen UI
// * parçaları tekrardan çizilir. Etkilenmeyenler aynısı gibi kalır.
// *
// * Eğer bir değere göre UI yeniden çizdirilecekse bunu mutableStateOf ile tutmalıyız ki Compose takip etsin. Eğer normal olarak tanımlarsak
// * Greeting fonksiyonu her çağrıldığında içindeki state sıfırlanacak.
// *
// * State ve MutableState değer tutan ve değer değiştiğinde UI'ın güncellenmesi için tetikleme yapan interface yapılarıdır.
// * Composable fonksiyonlar herhangi bir zamanda recomposition'a uğrayabilir. remember keywordünü, composable fonksiyon yeniden
// * oluşturulurken o state'i kaybetmemek için kullanıyoruz.
// *
// * Aynı composable'ı ekranın farklı bölümlerinden çağırırsanız, her biri kendi durum sürümüne sahip farklı UI öğeleri oluşturacağınızı
// * unutmayın. Dahili durumu bir sınıftaki özel bir değişken olarak düşünebilirsiniz.
// */
//
///**
// * Bu örnekte Column'a 1f weight değeri verildi. Bu yüzden dolayı o kısım 1f'lik bir alan kaplıyor fakat aynı hiyerarşi de başka
// * bir component'in weight değeri olmadığı için 1f oranın tamamı oluyor ve sonra gelen elemanlar direkt sona kayıyor. ElevatedButton'ın
// * weight değeri 5f olsaydı, row'u 6 parçaya ayıracaktı ve 5 birimini bu butona verecekti. Çünkü toplam 6 weight değerinin 5'ine sahip.
// * Bu weight değerinin row ile ilgili olduğunu da unutmayalım. Enine göre büyüme sağlatıyor. fillMaxWidth kullansaydık o column
// * ekranın en olarak tamamını kaplardı ve butona yer kalmazdı. Burada tek bir yerde weight kullandık ve diğer componentleri (burada
// * butonu kastediyoruz) olabildiğince sıkıştırdı.
// */
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Surface(
//        color = MaterialTheme.colorScheme.primary,
//        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//    ) {
//        Row(modifier = Modifier.padding(24.dp)) {
//            Column(modifier = Modifier.weight(1f)) {
//                Text(text = "Hello ")
//                Text(text = name)
//            }
//            ElevatedButton(// modifier = Modifier.weight(5f),
//                onClick = {
//
//                }
//            ) {
//                Text("Show more")
//            }
////            Text(text = "A")
////            Text(text = "B")
//            // Buradaki componentler olabildiğince sağ taraftan başlar. Column'ın weight değeri bunları iter.
//        }
//    }
//}

/**
 * Chapter - 7 -> State in Compose
 */

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            FirstCodelabTheme {
//                MyApp()
//            }
//        }
//    }
//}
//
//@Composable
//fun MyApp(
//    modifier: Modifier = Modifier,
//    names: List<String> = listOf("World", "Compose", "Android")
//) {
//    Column(modifier = modifier.padding(16.dp)) {
//        for (name in names) {
//            Greeting(name = name)
//        }
//    }
//}
//
///**
// * Compose'un state'i takip etmesi için mutableStateOf kullanıyoruz.
// *
// * Recomposition olduğunda değerinin tutulması için ise remember kullanıyoruz. Değerin resetlenmemesi için...
// *
// * Buradaki Greeting fonksiyonunu farklı yerlerde kullanabiliriz. Kullandığımız farklı yerlerde kendi state'lerine
// * sahip olurlar.
// */
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    // var expanded = false // Bu şekilde kullanım yapmamalıyız.
//    // Compose'un bunu bir durum değişikliği olarak algılamasını sağlamaz, bu nedenle hiçbir şey olmaz.
//    val expanded = remember { mutableStateOf(false) }
//    val extraPadding = if (expanded.value) 48.dp else 0.dp
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
//                Text(text = "Hello ")
//                Text(text = name)
//            }
//            ElevatedButton(
//                onClick = { expanded.value = !expanded.value }
//            ) {
//                Text(if (expanded.value) "Show less" else "Show more")
//            }
//        }
//    }
//}

/**
 * Chapter - 8 -> State Hoisting
 */

/**
 * State hoisting: Composable fonksiyonlarda stateler birden fazla yerde okunuyorsa veya değiştiriliyorsa bunlar,
 * olabildiğince hiyerarşideki en üst yapılara taşınmalı. Bu şekilde bir state'den birden çok tanımlamayız, daha az bugla karşılaşırız ve
 * composable, tekrar tekrar kullanılabilir hale gelir. Ek olarak test yazma işini de kolaylaştırır.
 */

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            FirstCodelabTheme {
//                MyApp(modifier = Modifier.fillMaxSize())
//            }
//        }
//    }
//}
//
///**
// * Compose'da bir şeyleri gizlemeyiz. Göstereceksek composable'a dahil ederiz, göstermeyeceksek dahil etmeyiz. Bunun için de
// * Kotlin kodlarında logicler yazabiliriz. If else gibi.
// *
// * Burada shouldShowOnboarding true ise başka bir component eğer değilse başka bir component göstereceğiz. Buradaki state
// * nereden gelmeli? İşte burada state hoisting yaparak bu state'i MyApp'e taşıyoruz. İlk başta true olduğu için
// * OnBoardingScreen gözükecek fakat sonradan false olacağı için Greetings gözükecek.
// */
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
///**
// * Higher order fonksiyonlar ile bir state durumunu değiştirebiliriz. İşleri çok kolaylaştırır.
// * Higher order func. <3
// */
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
//
//        Button(
//            modifier = Modifier.padding(vertical = 24.dp),
//            onClick = onContinueClicked
//        ) {
//            Text("Continue")
//        }
//    }
//}
//
//@Composable
//private fun Greetings(
//    modifier: Modifier = Modifier,
//    names: List<String> = listOf("World", "Compose")
//) {
//    Column(modifier = modifier.padding(vertical = 4.dp)) {
//        for (name in names) {
//            Greeting(name = name)
//        }
//    }
//}
//
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

/**
 * Chapter - 9 -> Creating a performant lazy list
 */

/**
 * Birkaç tane column'a alt alta koymuştuk. Peki ya binlerce varsa? Burada recycler view gibi bir yapıya ihtiyacımız
 * var. O da LazyColumn veya LazyRow ile sağlanıyor. Recycler view gibi bir yapıdır. Aşağı kaydırdıkça veriler yüklenir.
 */

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            FirstCodelabTheme {
//                Greetings(modifier = Modifier.fillMaxSize())
//            }
//        }
//    }
//}
//
///**
// * LazyColumn, Recycler view gibi childrenlarını yaymaz. Kaydırdıkça yeni composable'ları yayar (emit etmek).
// * Composable'lar View'lardan daha hafif olduğu için daha performanslıdır diyebiliriz.
// */
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

/**
 * Chapter - 10 -> Persisting state
 */

/**
 * 8.Chapter'da yaptığımız örneği düşünelim. Bir onBoarding ekranı vardı ve butona basınca başka bir composable geliyordu. Burada
 * bir problemimiz var. Eğer uygulama configurasyonu değişirse (ekranı yan çevirmek vs.) bu durumda onBoarding ekranı tekrar
 * gözükecektir. Çünkü state'i kaybettik. Bunun için rememberSaveable kullanabiliriz.
 *
 * Ek olarak şöyle bir örnekte, 1. butona bastık o column aşağı indi ve biz ekranı biraz aşağı kaydırdık. Sonra geri geldik diyelim. Bu durumda da state
 * sıfırlanır. Bunun için de yine rememberSaveable kullanabiliriz.
 *
 * var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
 */

/**
 * Chapter - 11 -> Animating your list
 */

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            FirstCodelabTheme {
//                MyApp(modifier = Modifier.fillMaxSize())
//            }
//        }
//    }
//}
//
//@Composable
//fun MyApp(modifier: Modifier = Modifier) {
//
//    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
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
//
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
///**
// * Animasyon için animateDpAsState composable fonksiyonunu kullanıyoruz. Bu, animasyon bitene kadar değeri
// * animasyon tarafından sürekli güncellenecek bir State nesnesi döndürür. Türü Dp olan bir "hedef değer" alır.
// *
// * Bu yapı içerisinde bir opsiyonel animationSpec parametresi barındırır. Bu animasyonun nasıl olacağını söyler.
// *
// * Ek bilgi olarak padding'e negatif değer verirsek uygulama crash olur.
// *
// * Buradaki animasyonu anında kesebiliriz. Butona hızlıca iki kere tıklarsak görebiliriz.
// *
// * Animasyonlar için -> https://developer.android.com/develop/ui/compose/animation/introduction
// */
//
//@Composable
//private fun Greeting(name: String, modifier: Modifier = Modifier) {
//
//    var expanded by rememberSaveable { mutableStateOf(false) }
//
//    val extraPadding by animateDpAsState(
//        targetValue = if (expanded) 48.dp else 0.dp,
//        animationSpec = spring(
//            dampingRatio = Spring.DampingRatioMediumBouncy,
//            stiffness = Spring.StiffnessLow
//        ),
//        label = "Animation"
//    )
//    Surface(
//        color = MaterialTheme.colorScheme.primary,
//        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//    ) {
//        Row(modifier = Modifier.padding(24.dp)) {
//            Column(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
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

/**
 * Chapter - 12 -> Styling and theming your app
 */

/**
 * Theme.kt içine bak!
 */

/**
 * FirstCodelabTheme'i kaldırıp composable'lar çalıştırırsak farkı görebiliriz. Burada Theme.kt içindeki
 * şablona uyuyoruz.
 *
 * Material Theme'ın colorScheme, typography ve shapes özelliklerini kullanarak özelleştirme yapabiliriz.
 *
 * Bu özellikleri mümkün olduğu kadar Theme dosyası içinde ayarlamalıyız. Dark mode için ayrı ayrı ayarlama
 * yapmak zorunda kalabiliriz. Fakat bazen daha spesifik işlemler yapmamız gerekebilir. Material Theme'in
 * verdiği şeylere ekleme yapmak isteyebiliriz. Bunun için copy kullanabiliriz. Örneğin aşağıda headlineMedium
 * kalınlık için yetersiz kaldı ve biz bunu daha da kalın hale getirdik.
 */
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            FirstCodelabTheme {
////                Text(
////                    text = "Hello Kotlin",
////                    style = MaterialTheme.typography.headlineMedium,
////                    color = MaterialTheme.colorScheme.tertiary,
////                )
//
////                Text(
////                    text = "Hello Android",
////                    style = MaterialTheme.typography.headlineMedium.copy(
////                        fontWeight = FontWeight.ExtraBold
////                    )
////                )
//
//                // Dark theme'e göre farklı renkler alıyor artık.
//                ElevatedButton(onClick = { }) {
//                    Text(text = "Hello Kotlin")
//                }
//            }
//        }
//    }
//}

/**
 * Chapter - 13 -> Finishing touches
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstCodelabTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    Surface(modifier, color = MaterialTheme.colorScheme.background) {
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            Greetings()
        }
    }
}

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(1000) { "$it" }
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

@Composable
private fun Greeting(name: String, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name)
    }
}

@Composable
private fun CardContent(name: String) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "Hello, ")
            Text(
                text = name, style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            if (expanded) {
                Text(
                    text = ("Composem ipsum color sit lazy, " +
                            "padding theme elit, sed do bouncy. ").repeat(4),
                )
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) {
                    "Show Less"
                } else {
                    "Show More"
                }
            )
        }
    }
}

