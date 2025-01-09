package com.example.lemonade

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                    LemonadeApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp(){

    var currentStep by remember { mutableStateOf(1) }

    var squeezeCount by remember { mutableStateOf(0) }


        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentStep) {
                1 -> {
                    LemonadeAppImageAndText(
                        textLableResourceId = R.string.lemon_select,
                        contenDiscriptionId = R.string.lemon_tree_content_discripion,
                        imageResourceId = R.drawable.lemon_tree,
                        oneImageClick = {
                            currentStep = 2
                            squeezeCount = (2..4).random()
                        }
                    )
                }

                2 -> {
                    LemonadeAppImageAndText(
                        textLableResourceId = R.string.lemon_select,
                        contenDiscriptionId = R.string.lemon_tree_content_discripion,
                        imageResourceId = R.drawable.lemon_squeeze,
                        oneImageClick = {
                            squeezeCount--
                            if (squeezeCount == 0)
                                currentStep = 3
                        }
                    )

                }

                3 -> {
                    LemonadeAppImageAndText(
                        textLableResourceId = R.string.lemon_select,
                        contenDiscriptionId = R.string.lemon_tree_content_discripion,
                        imageResourceId = R.drawable.lemon_drink,
                        oneImageClick = {
                            currentStep = 4

                        }
                    )

                }

                4 -> {
                    LemonadeAppImageAndText(
                        textLableResourceId = R.string.lemon_select,
                        contenDiscriptionId = R.string.lemon_tree_content_discripion,
                        imageResourceId = R.drawable.lemon_restart,
                        oneImageClick = {
                            currentStep = 1
                        }
                    )
                }
            }
        }
    }


@Composable
fun LemonadeAppImageAndText(
    textLableResourceId: Int,
    imageResourceId : Int,
    contenDiscriptionId: Int,
    oneImageClick: () -> Unit,
    modifier: Modifier = Modifier)
{
    Box(modifier = modifier)
    {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Button(
                onClick = oneImageClick
            ) {
                Image(
                    painter = painterResource(imageResourceId),
                    contentDescription = stringResource(contenDiscriptionId)

                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(textLableResourceId)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    LemonadeApp()
}