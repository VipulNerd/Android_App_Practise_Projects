package com.example.businesscard

import android.content.res.Resources
import android.graphics.drawable.Icon
import android.os.Bundle
import android.webkit.WebSettings.TextSize
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp(
                        Color(0xFF42f28d)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(backGround: Color,modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.background(backGround)
    ) {
        BusinessCardLogo(
            "Vipul Gupta",
            "Hello wanna conatact me below are my details",
            painterResource(R.drawable.android_logo) ,
        )

        BusinessCardContact(
            "99988978787",
            "ihaeoifjhaoincao",
            "kjabfk"
            )

    }

}

@Composable
private fun BusinessCardLogo(title: String, discription: String, imagePainter: Painter, modifier: Modifier = Modifier,){
    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null
        )
        Text(
            text = title,
            modifier = modifier.padding(10.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Text(
            text = discription,
            modifier = modifier.padding(10.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun BusinessCardContact(phone: String, email: String, share: String,modifier: Modifier = Modifier ){
    Column(
        modifier = modifier.padding(start = 125.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
    Row() {
        Icon(Icons.Default.Phone, contentDescription = "Localized description")
        Text(
            text = phone
        )
    }
    Row {
        Icon(Icons.Default.Email, contentDescription = "Localized description")
        Text(
            text = email
        )
    }
    Row{
        Icon(Icons.Default.Share, contentDescription = "Localized description")
        Text(
            text = share
        )
    }
    }
}


@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCardApp(Color(0xFF42f28d))
    }
}