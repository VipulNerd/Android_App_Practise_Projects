package com.example.superheroes


import SuperheroesTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.DataSources
import com.example.superheroes.model.Hero



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                SuperheroesTheme {
                    SuperHeroApp()
                }
        }
    }
}

@Composable
fun SuperHeroApp() {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopBar(modifier = Modifier)
        }
    ) {

        HeroList(
            heroList = DataSources.heroes(),
            modifier = Modifier.padding(it)
        )
    }
}

@Composable
fun SuperHeroCard(hero: Hero, modifier: Modifier){
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier) {
        Row( modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .sizeIn(minHeight = 72.dp)){
            Column (modifier = Modifier.weight(1f)){
                Text(
                    text = stringResource(hero.nameRes),
                    modifier = Modifier
                )

                Text(
                    text = stringResource(hero.descriptionRes),
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier
                .size(72.dp)
                .clip(RoundedCornerShape(8.dp))
            ){
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = stringResource(hero.descriptionRes),
                    alignment = Alignment.Center,
                    contentScale =  ContentScale.FillWidth,

                )
            }
        }
    }
}

@Composable
fun HeroList(heroList: List<Hero>, modifier: Modifier,  contentPadding: PaddingValues = PaddingValues(0.dp)){

        LazyColumn(contentPadding = contentPadding) {
            items(heroList) { hero ->
                SuperHeroCard(
                    hero = hero,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun SuperHeroPreview() {
    SuperheroesTheme {
        SuperHeroApp()
    }
}