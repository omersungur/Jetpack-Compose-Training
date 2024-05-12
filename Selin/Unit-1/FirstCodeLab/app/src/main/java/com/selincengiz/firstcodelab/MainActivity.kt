package com.selincengiz.firstcodelab

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.selincengiz.firstcodelab.ui.theme.FirstCodeLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstCodeLabTheme {
                //Sayfanın tamamının ayrı bir composable olarak kullanılması
                //preview kısmında kolaylık sağlamaktadır.
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    //by keyword'u gibi property delegate'ler kodun kullanımını kısaltır.
    //bir önceki kullanımda olduğu gibi shouldShowOnboarding.value yazılmasına gerek kalmaz.
    //shouldShowOnboarding yazmak yeterlidir.
    //Rotate ve dark mode gibi konfigürasyon değişikliklerinde state tutulmaz.
    //Statetin tutulması için rememberSaveable kullanılmalıdır.

    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    //Temel olarak, state hoisting, bir bileşenin içindeki durumun,
    //onu içeren bileşene taşınması anlamına gelir. Bu, daha büyük bir
    //bileşende durumun tek bir kaynağa sahip olmasını sağlar ve
    //alt bileşenler arasında durumun paylaşılmasını kolaylaştırır.
    //onContinueClicked fonksiyonu ile state hoisting sağlanmıştır.
    //OnboardingScreen içerisinde gerçekleşen event high order fonksiyon
    //kullanımı ile dış katmana taşınmıştır.
    if (shouldShowOnboarding) {
        OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
    } else {
        Greetings()
    }
}

@Composable
fun Greetings(names: List<String> = List(1000) { "$it" }) {
    Surface(
        color = MaterialTheme.colorScheme.background,
    ) {
        Column {
            //LazyColumn xml'deki recyclerview ile eş kabul edilebilir.
            //Xml'deki gibi adapter yazılmasına gerek yoktur.
            LazyColumn {
                item { Text(text = "Header") }
                items(names) { name ->
                    Greeting(name)
                }
            }
            /*
            //Bir listeye bağlı olarak oluşturulacak widgetlar için
            //for loop ile composable fonksiyonlar çağırılabilir
            //büyük size'a sahip listeler için kullanılmamalıdır.
            //Size büyük olduğu takdirde LazyRow veya LazyColumn kullanılır.
            for (name in names) {
                Greeting(name)
            }*/
        }
    }
}


@Composable
fun Greeting(name: String) {
    //mutableStateOf sadece bir booleandan ziyade bir state döndürür.
    //Bu state ile birlikte ui recomposition sağlanması amaçlanmıştır.
    //State değiştiğinde ui'da değişecektir.
    //remember fonksiyonu recomposition gerçekleştiğinde
    //state değişkeninin değerinin resetlenmemesi ve saklanması amacıyla kullanılmaktadır.
    val expanded = remember {
        mutableStateOf(false)
    }

    //Ekstra padding ile satırın genişletilmesi işlemi sağlanıyor 
    //bu paddding işlemine animation eklenebilmektedir.
    //animation spec animasyonları özelleştirmek için kullanılabilir.
    val extraPadding by animateDpAsState(
        targetValue = if (expanded.value) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = "Hello,")
                Text(text = name)
            }
            /*
         //OutlinedButton video codelab'te kullanılmıştır.
         //Outlined button container color'u default olarak transparent olduğu
         //için colors parametresiyle surface rengine ayarlıyoruz.
         //Codelab içerisindeki rounded button tasarımı için roundedCornerShape eklenmiştir.

        OutlinedButton(
                 shape = RoundedCornerShape(5.dp),
                 colors = ButtonDefaults.outlinedButtonColors(containerColor = MaterialTheme.colorScheme.surface),
                 onClick = { expanded.value = !expanded.value }) {
                 Text(if (expanded.value) "Show less" else "Show more")
             }*/

            ElevatedButton(
                onClick = { expanded.value = !expanded.value }) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }

    }
}

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    // TODO: This state should be hoisted

    //Vertical arrangement column container'ın bütün childlarını dikey olarak centera alır
    //Horizontal alignment column container'ın bütün childlarını yatay olarak centera alır
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

//Tek bir composable üzerine farklı preview'lar eklenebilir.
//uiMode ile birlikte gece modu preview'da sağlanmıştır.
@Preview(
    showBackground = true,
    widthDp = 320,
    heightDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnBoardingPreview() {
    FirstCodeLabTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    FirstCodeLabTheme {
        MyApp()
    }
}

// Surface ve Modifier parametreleri
/*
@Composable
fun MyApp() {
    // Surface tema için kullanılan bir composable fonksiyondur.
    // Default değerler aşağıda verildiği gibidir.
    // Tema değişikliği istendiğinde parametreler değiştirilmelidir.
    // Yazdığımız composable fonksiyonlarda tema için
    // bu surface widget'ı ile sarmalama yapabiliriz.

    /*
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    color: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = contentColorFor(color),
    tonalElevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
    border: BorderStroke? = null,
    content: @Composable () -> Unit
     */

    // Modifier, compose için oldukça önemli bir bileşendir.
    //UI bileşenlerini şekillendirmek, konumlandırmak ve düzenlemek için kullanılır.
    //Modifier'ın içerebileceği özellikler aşağıda listelenmiştir.

    /*
    padding: Bileşenin iç kenar boşluklarını belirler.
    width ve height: Bileşenin genişliğini ve yüksekliğini belirler.
    fillMaxWidth ve fillMaxHeight: Bileşenin maksimum genişliğini ve yüksekliğini doldurmasını sağlar.
    align: Bileşenin diğer bileşenlere göre hizalanmasını sağlar.
    clickable: Bileşene tıklanabilirlik özelliği ekler.
    background: Bileşenin arka plan rengini belirler.
    border: Bileşene bir kenarlık ekler.
    clip: Bileşenin sınırlarını kırpar.
    offset: Bileşenin konumunu belirler.*/



    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(24.dp),
        shape = CircleShape,
        tonalElevation = 28.dp,
        shadowElevation = 25.dp,
        border = BorderStroke(2.dp,MaterialTheme.colorScheme.error)
    ) {
        Text(text = "Hello",
            modifier = Modifier.padding(10.dp))
    }
}
*/