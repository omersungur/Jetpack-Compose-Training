package com.omersungur.secondcodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.omersungur.secondcodelab.ui.theme.SecondCodelabTheme

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

private val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab1_inversions to R.string.ab1_inversions,
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
).map { DrawableStringPair(it.first, it.second) }

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            MySootheApp(windowSizeClass)
        }
    }
}

/**
 * Bir tasarım yaparken adım adım onu parçalara ayır. Örneğin ilk başta scaffold iskeletindeki componentleri ayır.
 * Ardondan o componentleri de kendi içinde parçalara ayır. Örneğin column - row vs vs.
 */

/**
 * Composable'larda default olarak modifier tanımlamak daha esnek ve kullanılabilir olmasını sağlar.
 *
 * Modifier zincirindeki heightIn ile minimum ve maksimum yüksekliği ayarlayabiliyoruz. Ek olarak kullanıcı
 * metin boyutunu arttırırsa componentimiz de büyüyecektir.
 *
 * Buradaki leadingIcon text field'ın en solunda yer alan ikonu temsil ediyor.
 *
 * TextField için verdiğimiz colors parametresinde unFocused ve focused olmak üzere 2 tane renk
 * parametresi var. Eğer text field'a tıklarsak focused rengi, tıklamazsak unfocused rengi kullanılır.
 *
 * Place holder, hiçbir şey yazılmadığında yer alan metni temsil ediyor.
 */

@Composable
fun MySootheApp(windowSize: WindowSizeClass) {
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            MySootheAppPortrait()
        }

        WindowWidthSizeClass.Expanded -> {
            MySootheAppLandscape()
        }
    }
}

@Composable
fun MySootheAppLandscape() {
    SecondCodelabTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                SootheNavigationRail()
                App()
            }
        }
    }
}

@Composable
fun MySootheAppPortrait() {
    // Implement composable here
    SecondCodelabTheme {
        Scaffold(
            bottomBar = { SootheBottomNavigation() }
        ) { padding ->
            App(Modifier.padding(padding))
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    Column(
        modifier.verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))

        SearchBar(Modifier.padding(horizontal = 16.dp))

        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }

        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid()
        }

        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
) {
    var query by remember { mutableStateOf("") }

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        value = query,
        onValueChange = {
            query = it
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text("Search")
        },
    )
}

/**
 * Bir metnin taban çizgisi, harflerin oturduğu çizgidir.
 *
 * Image 88.dp boyutunda olmalı bunu size ile verebiliriz. size hem width hem height ifadesini aynı anda ifade eder.
 * Image yuvarlak olduğu için clip ile şeklini verebiliriz. clip fonksiyonu içerisine Shape alır.
 *
 * Resmin düzgün bir şekilde ölçeklenmesi için contentScale parametresini kullanabiliriz. Burada Crop
 * vererek orantılı olarak ölçeklenebilir. Tabii yandaki detayların biraz kesildiğini unutmayalım.
 * Tam olarak bütün resmi getirmesini istiyorsak FillBounds kullanabiliriz.
 *
 * paddingFromBaseline yapısı padding'den farklı bir şekilde görev yapıyor. Alttaki örnekte padding kullansaydık
 * yazının hemen üstüyle fotoğraf arasında padding bırakacaktı fakat paddingFromBaseline ile yazının en oturduğu
 * yerden resim ile bir padding bırakıyoruz.
 *
 */

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape) // MaterialTheme.shapes.medium gibi değerler de verilebilir.
        )

        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

/**
 * Surface içerisine componentler gömebileceğimiz bir componenttir. Tam olarak yüzey görevi görür. İstediğimiz
 * gibi şekillendirip modifiye edebiliriz.
 *
 * Surface şeklindi MaterialTheme.shapes.medium şeklinde Material içinden verebiliriz. BodyElement içinde
 * shape'i CircleShape olarak paslamıştık. Hepsinin dp değerleri arka planda yazıyor.
 */

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )

            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

/**
 * Row içindeki her elemanın arasındaki boşluğu spacedBy ile sağlayabiliriz. Fakat bu sadece bütün elemanlar
 * arasındaki boşluğu ifade eder. En solda bulunan eleman ile onun solunda bulunan kısım ile bir padding
 * bırakmaz. Bunun için contentPadding parametresi için PaddingValues parametresini kullanabiliriz.
 */

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(item.drawable, item.text)
        }
    }
}

/**
 * Yine bir row satırı gerekiyor fakat bu sefer alt alta 2 row kombinasyonuyla birlikte bir
 * tasarım yapmamız lazım. Bunun için LazyHorizontalGrid kullanıyoruz.
 */

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)
    ) {
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(item.drawable, item.text, Modifier.height(80.dp))
        }
    }
}

/**
 * Her bir bölümün başlığı ve o başlığın bir içeriği var. Bunu bir component olarak tasarlayabiliriz.
 * HomeSection, bir başlık bir de composable fonksiyon alıyor. Buradaki content fonksiyonu içeriğimiz olacak.
 *
 * Slot API
 */

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )

        content()
    }
}

@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = true,
            onClick = {}
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_profile))
            },
            selected = false,
            onClick = {}
        )
    }
}

/**
 * Navigasyon barı en solda dikey bir şekilde yer alan bir component olarak tasarlayabiliriz.
 */

@Composable
private fun SootheNavigationRail(modifier: Modifier = Modifier) {
    // Implement composable here
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottom_navigation_home))
                },
                selected = true,
                onClick = {}
            )

            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottom_navigation_profile))
                },
                selected = false,
                onClick = {}
            )
        }
    }
}