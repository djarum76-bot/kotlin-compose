package com.example.namecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.namecard.ui.theme.NameCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NameCardTheme {
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
fun TopSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.android_logo), contentDescription = null)
        Text(
            text = "Jennifer Doe",
            fontSize = 34.sp,
            fontFamily = FontFamily.Serif,
            color = Color.White
        )
        Text(
            text = "Android Developer Extraordinaire",
            fontFamily = FontFamily.Serif,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Green
        )
    }
}

@Composable
fun BottomSection(){
    Column {
        Divider(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp), color = Color.White)
        BottomData(icon = Icons.Rounded.Call, data = "+ 11 (123) 444 555 666")
        Divider(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp), color = Color.White)
        BottomData(icon = Icons.Rounded.Share, data = "@AndroidDev")
        Divider(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp), color = Color.White)
        BottomData(icon = Icons.Rounded.Email, data = "jen.doe.@android.com")
    }
}

@Composable
fun BottomData(icon: ImageVector, data: String){
    Row(modifier = Modifier.padding(start = 32.dp, end = 32.dp, top = 8.dp, bottom = 8.dp)) {
        Icon(imageVector = icon, contentDescription = null, tint = Color.Green)
        Text(text = data, fontFamily = FontFamily.Serif, color = Color.White, modifier = Modifier.padding(start = 16.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    NameCardTheme {
        Surface(color = Color.DarkGray) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 16.dp, top = 16.dp)
            ) {
                TopSection(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .padding(24.dp)
                )
                BottomSection()
            }
        }
    }
}