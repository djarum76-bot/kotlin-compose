package com.example.amphibians.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.R
import com.example.amphibians.data.AmphibianData
import com.example.amphibians.viewmodel.AmphibianUiState

@Composable
fun HomeScreen(retryAction: () -> Unit, modifier: Modifier = Modifier, amphibianUiState: AmphibianUiState){
    when(amphibianUiState){
        is AmphibianUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is AmphibianUiState.Error -> ErrorScreen(retryAction = retryAction, modifier = Modifier.fillMaxSize())
        is AmphibianUiState.Success -> SuccessScreen(amphibians = amphibianUiState.amphibians, modifier = Modifier
            .fillMaxSize()
        )
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier){
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(id = R.drawable.loading_img),
        contentDescription = null
    )
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier, retryAction: () -> Unit){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error),
            contentDescription = null
        )
        Text(
            text = stringResource(id = R.string.loading_failed),
            modifier = Modifier.padding(16.dp)
        )
        Button(onClick = retryAction) {
            Text(text = stringResource(id = R.string.retry))
        }
    }
}

@Composable
fun SuccessScreen(modifier: Modifier = Modifier, amphibians: List<AmphibianData>){
    LazyColumn(
        modifier = modifier
    ){
        items(amphibians){
            AmphibianCard(amphibian = it, modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp))
        }
    }
}

@Composable
fun AmphibianCard(modifier: Modifier = Modifier, amphibian: AmphibianData){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            AmphibianInformation(amphibian = amphibian, modifier = Modifier.padding(top = 16.dp, bottom = 8.dp, end = 16.dp, start = 16.dp))
            AmphibianImage(amphibian = amphibian, modifier = Modifier.height(200.dp))
        }
    }
}

@Composable
fun AmphibianInformation(modifier: Modifier = Modifier, amphibian: AmphibianData){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${amphibian.name} (${amphibian.type})",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = amphibian.description,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun AmphibianImage(modifier: Modifier = Modifier, amphibian: AmphibianData){
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current).data(amphibian.imgSrc).crossfade(true).build(),
        contentDescription = null,
        error = painterResource(R.drawable.ic_broken_image),
        placeholder = painterResource(R.drawable.loading_img),
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth()
    )
}