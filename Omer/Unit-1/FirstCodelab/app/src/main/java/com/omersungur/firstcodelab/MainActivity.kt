package com.omersungur.firstcodelab

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omersungur.firstcodelab.ui.theme.FirstCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstCodelabTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp(modifier = Modifier.fillMaxWidth())
                }
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

//// Modifier, bir kullanıcı arayüzü öğesine ana düzeninde nasıl yerleştirileceğini, görüntüleneceğini veya davranacağını söyler.
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Surface(
//        color = MaterialTheme.colorScheme.primary,
//        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//    ) {
//        // Yazı ile içindeki container arasındaki padding
//        Column(modifier = modifier.padding(24.dp)) {
//            Text(text = "Hello ")
//            Text(text = name)
//        }
//    }
//}

// Weight, öğenin mevcut tüm alanı doldurmasını sağlayarak onu esnek hale getirir ve esnek olmayan olarak
// adlandırılan, ağırlığı olmayan diğer öğeleri etkili bir şekilde iter. Ayrıca fillMaxWidth değiştiricisini gereksiz hale getirir.
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Hello ")
                Text(text = name)
            }
            ElevatedButton(
                onClick = {

                }
            ) {
                Text("Show more")
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    FirstCodelabTheme {
//        Greeting("Android")
//    }
//}

/**
 * Her UI elementini bir yere yazmak kod okunaklığını azaltır bu yüzden UI'ları küçük composable fonksiyonlarına bölerek
 * tekrar tekrar kullanmak daha iyidir.
 *
 * Best practice olarak bir composable fonksiyonunda default olarak modifier olması iyidir.
 * Daha sonradan başka bir yerde modifiye etmek isteyebiliriz.
 */