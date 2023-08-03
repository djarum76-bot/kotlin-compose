package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var index by remember { mutableStateOf(0) }
    var count by remember { mutableStateOf(0) }
    val onClick = {
        when(index){
            0, 2 -> index += 1
            3 -> index = 0
            else -> when(count){
                Random.nextInt(2, 5) -> {
                    count = 0
                    index += 1
                }
                else -> count += 1
            }
        }
    }

    val title = arrayOf(
        "Tap the lemon tree to select a lemon",
        "Keep tapping the lemon to squeeze it",
        "Tap the lemonade to drink it",
        "Tap the empty glass to start again"
    )

    val image = intArrayOf(
        R.drawable.lemon_tree,
        R.drawable.lemon_squeeze,
        R.drawable.lemon_drink,
        R.drawable.lemon_restart
    )

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = title[index])
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.background),
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
            border = BorderStroke(color = Color.Cyan, width = 1.dp)
        ) {
            Image(painter = painterResource(id = image[index]), contentDescription = null)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonadeApp(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center)
        )
    }
}