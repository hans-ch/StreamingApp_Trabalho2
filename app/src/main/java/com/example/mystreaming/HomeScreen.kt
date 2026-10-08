package com.example.mystreaming

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

//Item filme e seus atributos
data class MediaItem(
    val id : Int,
    val title: String,
    val year: String,
    val rating: String
)

//Lista com itens de teste
val sampleMediaList = listOf(
    MediaItem(1, "Jornada pro Oeste", "2012", "6.7"),
    MediaItem(2, "A mulher na lua", "1997", "7.7"),
    MediaItem(3, "Filme 3", "2023", "8.0"),
    MediaItem(4, "Filme 4", "2024", "9.1")
)

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF1E2A78))
        .verticalScroll(rememberScrollState())
        .padding(bottom = 24.dp)){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically){
            Text(
                text = "LogoApp",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        MediaSection(title = "Recomendações", items = sampleMediaList)
        MediaSection(title = "Novidades", items = sampleMediaList)
        MediaSection(title = "Sua lista", items = sampleMediaList)
    }
}

@Composable
fun MediaSection(title: String, items: List<MediaItem>) {
    Column(modifier = Modifier.padding(vertical = 12.dp)) {
        // Título da Seção
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        // Lista Horizontal com os Cards
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items) { item ->
                MediaCard(item = item)
            }
        }
    }
}

@Composable
fun MediaCard(item: MediaItem) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .height(180.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
           // Modifier.clickable(onClick = {navController.navigate()}),
            modifier = Modifier.fillMaxSize()
        ) {

            // Tarja com informações na parte inferior
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .background(Color.Black.copy(alpha = 0.75f))
                    .padding(6.dp)
            ) {
                Text(
                    text = item.title,
                    color = Color.White,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = item.year, color = Color.LightGray, fontSize = 9.sp)
                    Text(text = item.rating, color = Color.White, fontSize = 9.sp)
                }
            }
        }
    }
}