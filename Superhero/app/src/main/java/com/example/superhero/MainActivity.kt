package com.example.superhero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.superhero.data.Datasource
import com.example.superhero.model.Hero
import com.example.superhero.ui.theme.SuperheroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroTheme {
                SuperheroApp()
            }
        }
    }
}

@Composable
fun SuperheroApp() {
    Scaffold(
        topBar = {
            SuperheroTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(Datasource().heroes) {
                SuperheroItem(hero = it, modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperheroTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title ={
            Text(text = stringResource(id = R.string.app_name), style = MaterialTheme.typography.displayLarge)
        },
        modifier = modifier
    )
}

@Composable
fun SuperheroItem(modifier: Modifier = Modifier, hero: Hero) {
    Card(modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            SuperheroInformation(heroName = hero.nameRes, heroDesc = hero.descriptionRes, modifier = Modifier
                .weight(4f))
            Spacer(modifier = Modifier.width(4.dp))
            SuperheroImage(heroImage = hero.imageRes, modifier = Modifier
                .weight(1f))
        }
    }
}

@Composable
fun SuperheroInformation(
    modifier: Modifier = Modifier,
    @StringRes heroName: Int,
    @StringRes heroDesc: Int
) {
    Column(modifier = modifier) {
        Text(text = stringResource(id = heroName), style = MaterialTheme.typography.displaySmall)
        Text(text = stringResource(id = heroDesc), style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun SuperheroImage(modifier: Modifier = Modifier, @DrawableRes heroImage: Int) {
    Image(
        painter = painterResource(id = heroImage),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(72.dp)
            .clip(MaterialTheme.shapes.medium)
    )
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun DefaultPreview() {
//    SuperheroTheme {
//        Greeting("Android")
//    }
//}