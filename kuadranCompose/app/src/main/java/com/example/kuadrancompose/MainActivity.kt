package com.example.kuadrancompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kuadrancompose.ui.theme.KuadranComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KuadranComposeTheme {
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
fun QuadronComposable(title: String, content: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight(700),
                modifier = Modifier.padding(end = 16.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = content,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    KuadranComposeTheme {
        Column {
            Row(modifier = Modifier.fillMaxSize().weight(1f)) {
                QuadronComposable(
                    title = "Text composable",
                    content = "Displays text and follows Material Design guidelines.",
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(color = Color.Green)
                )
                QuadronComposable(
                    title = "Image composable",
                    content = "Creates a composable that lays out and draws a given Painter class object.",
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(color = Color.Yellow)
                )
            }
            Row(modifier = Modifier.fillMaxSize().weight(1f)) {
                QuadronComposable(
                    title = "Row composable",
                    content = "A layout composable that places its children in a horizontal sequence.",
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(color = Color.Blue)
                )
                QuadronComposable(
                    title = "Column composable",
                    content = "A layout composable that places its children in a vertical sequence.",
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(color = Color.Magenta)
                )
            }
        }
    }
}