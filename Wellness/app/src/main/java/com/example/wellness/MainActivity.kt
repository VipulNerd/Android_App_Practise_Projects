package com.example.wellness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wellness.model.Wellness
import com.example.wellness.ui.theme.WellnessTheme
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.example.wellness.model.DataSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WellnessTheme {
                   WellnessApp()
            }
        }
    }
}

@Composable
fun WellnessApp() {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopBar(modifier = Modifier)
        }
    ) {
        WellnessGrid(
            wellList = DataSource.WellnessQuote(),
            modifier = Modifier
                .padding(it)
        )
    }
}



@Composable
fun WellnessGrid(wellList: List<Wellness>, modifier: Modifier){
    LazyColumn(modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(36.dp)) {
        items(wellList) { well ->
            QuoteCard(well = well, modifier = Modifier
                .padding(bottom = 16.dp, top=8.dp).fillMaxWidth())
        }
    }
}

@Composable
fun QuoteCard(well: Wellness, modifier: Modifier){
    var expanded by remember { mutableStateOf(false) }
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.padding(top = 90.dp, bottom = 8.dp)){
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .padding(16.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement =  Arrangement.SpaceBetween){
                Text(
                    text = stringResource( well.titleRes),
                    modifier = Modifier.weight(1f)
                )
                WellnessButton(
                    expanded = expanded,
                    onClick = {expanded = !expanded},
                    modifier = Modifier
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(well.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            if(expanded){
                WellnessDes(
                    quoteId = (well.quote),
                    modifier = Modifier.height(8.dp)
                )
            }

        }
    }
}

@Composable
fun WellnessDes(
    @StringRes quoteId: Int,
    modifier: Modifier
){
    Column{
        Text(
            text = stringResource(R.string.About)
        )
        Text(
            text = stringResource(quoteId)
        )
    }
}

@Composable
fun WellnessButton(
    expanded: Boolean,
    onClick :()->Unit,
    modifier: Modifier
){
    IconButton(
        onClick = onClick,
        modifier = Modifier
    ) {
        Icon(
            imageVector =  Icons.Filled.ArrowDropDown,
            contentDescription = stringResource(R.string.quote1),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayMedium
            )
        },
        modifier = Modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WellnessTheme {
        WellnessApp()
    }
}