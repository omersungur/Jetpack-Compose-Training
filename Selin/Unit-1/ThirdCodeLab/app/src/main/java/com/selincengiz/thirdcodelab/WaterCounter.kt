package com.selincengiz.thirdcodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//Bu composable state tutmaktadır,
//farklı stateless fonksiyonlar içerisinde çağrılabilir.
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableIntStateOf(0) }
    StatelessCounter(
        count = count,
        onIncrement = { count++ },
        modifier = modifier
    )
//Farklı bir onIncrement ile de tanımlanabilir
    /*  StatelessCounter(
          count = count,
          onIncrement = { count*2 },
          modifier = modifier
      )*/
}

//State Hoisting kullanılmıştır, count state'i
//daha dış bir composable içerisinde tutulmaktadır.
@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(
            onClick = onIncrement,
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add one")
        }
    }
}

/*
//STATE HOİSTİNG KULLANILMAMIŞ HALİ
//count değişkeni hardcoded değil state olarak tutulmalıdır.
//Böylece observable bir yapı elde ederiz.
//State değiştiğinde recomposition tetiklenir.
//rememberSaveable eklenmediği takdirde recomposition
//gerçekleştiği halde değişken değerleri hatırlanmayacağı için
//değişiklik gözlemlenemez. Bu keywordu ise recomposition
//gerçekleştiğinde state'in hatırlanmasını sağlamaktadır.
@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by remember { mutableIntStateOf(0) }
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = { count++ }, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}*/