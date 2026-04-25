package com.example.kampsuku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kampsuku.ui.theme.KampsuKuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KampsuKuTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LogoKampus()
                    Greeting(
                        name = "KampusKu",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LogoKampus(modifier: Modifier = Modifier) {
    var result by remember {
        mutableStateOf( value = 1 )
    }

    val kampusResource = when ( result ) {
        1 -> R.drawable.logo_amikom
        2 -> R.drawable.logo_ugm
        3 -> R.drawable.logo_itb
        4 -> R.drawable.logo_ui
        else -> R.drawable.logo_uny

    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource( kampusResource),
            contentDescription = result.toString(),
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height( height = 16.dp))

        Button(onClick = { result = (1..5).random() }) {
            Text( stringResource( R.string.acak_button))
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = buildAnnotatedString {
                append("Kampus")

                withStyle(
                    style = SpanStyle(color = Color(0xFFFFA500))
                ) {
                    append("Ku")
                }
            },
            modifier = Modifier.padding(40.dp),
            fontSize = 24.sp,
            letterSpacing = 3.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.weight(1f))

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Halo pengguna\nSelamat datang di Aplikasi KampusKu",
                modifier = Modifier.padding(30.dp),
                fontSize = 12.sp,
                letterSpacing = 1.5.sp,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        Column(
          modifier = modifier.fillMaxSize(),
          verticalArrangement = Arrangement.Bottom,
          horizontalAlignment = Alignment.CenterHorizontally
      ){
          Text(
              text = "Pilih Kampus Favorit Anda",
              modifier = Modifier.padding(18.dp),
              fontSize = 18.sp,
              letterSpacing = 3.sp,
              fontStyle = FontStyle.Italic
          )
      }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KampsuKuTheme {
        LogoKampus()
    }
}