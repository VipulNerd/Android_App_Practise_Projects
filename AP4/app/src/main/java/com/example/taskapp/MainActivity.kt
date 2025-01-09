package com.example.taskapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskapp.ui.theme.TaskAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskAppTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    TaskMessageApp()
                }
            }
        }
    }
}

@Composable
fun TaskMessageApp() {
    TaskMessage("All tasks completed", "Nice work!", painterResource(R.drawable.ic_task_completed) )
}

@Composable
private fun TaskMessage(title: String, greet: String, imagePainter: Painter, modifier: Modifier = Modifier){

    Column(modifier = modifier
       .fillMaxSize()
       .padding(16.dp),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally) {  Image(painter = imagePainter, contentDescription = null)
    Text(
        text = title,
        modifier.padding(top = 24.dp, bottom = 8.dp),
        fontWeight = FontWeight.Bold,
    )
    Text(
        text = greet,
        fontSize = 16.sp
    )
}
}

@Preview(showBackground = true)
@Composable
fun TaskMessageAppPreview() {
    TaskAppTheme {
       TaskMessageApp()
    }
}