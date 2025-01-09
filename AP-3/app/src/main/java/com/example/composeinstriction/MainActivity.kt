package com.example.composeinstriction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeinstriction.ui.theme.ComposeInstrictionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeInstrictionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeText()
                }
        }
    }
}

@Composable
fun ComposeText() {
    ComposeImage(title = "Jetpack Compose Tutorial", stringResource(R.string.shortDiscription_text),
        stringResource(R.string.longDiscripton_text),
        painterResource(R.drawable.bg_compose_background)
    )
}
@Composable
private fun ComposeImage(title: String,shortDiscription: String, longDiscription: String, imagePainter: Painter, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(painter = imagePainter, contentDescription = null)

    Text(
        text = title,
        modifier.padding(16.dp),
        fontSize = 24.sp
    )

    Text(
        text = shortDiscription,
        modifier.padding(start = 16.dp, end = 16.dp),
        textAlign = TextAlign.Justify
    )
    Text(
        text = longDiscription,
        modifier.padding(16.dp),
        textAlign = TextAlign.Justify
    )
    }

}




@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    ComposeInstrictionTheme {
       ComposeText()
    }
}
}