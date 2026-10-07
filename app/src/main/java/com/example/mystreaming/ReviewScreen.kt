package com.lfcom.firstandroid

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Preview(showBackground = true)
@Composable
fun ReviewScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF1E2A78)) // Cor de fundo azul similar ao layout
        .verticalScroll(rememberScrollState())
        .padding(bottom = 24.dp))
    {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically)
        {
            Text(
                text = "LogoApp",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }



        Spacer(modifier = Modifier.height(32.dp))
        MediaImage(title = "Nome do filme")

        Spacer(modifier = Modifier.height(16.dp))
        Avaliacao()

        Spacer(modifier = Modifier.height(16.dp))
        Formulari()





    }
}

@Preview
@Composable
fun MediaImage(title: String = ""){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))

        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier
            .size(width = 200.dp, height = 300.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))

        )

    }

}



@Preview
@Composable
fun Avaliacao() {
    Column(modifier = Modifier.padding(vertical = 12.dp)) {

        Box(modifier = Modifier.fillMaxSize()) {

            // Tarja com informações na parte inferior
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(horizontal = 80.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(modifier = Modifier
                        .size(40.dp)
                        .background(color = Color.Yellow, shape = CircleShape))
                    Box(modifier = Modifier
                        .size(40.dp)
                        .background(color = Color.Yellow, shape = CircleShape))
                    Box(modifier = Modifier
                        .size(40.dp)
                        .background(color = Color.Yellow, shape = CircleShape))
                    Box(modifier = Modifier
                        .size(40.dp)
                        .background(color = Color.Yellow, shape = CircleShape))
                    Box(modifier = Modifier
                        .size(40.dp)
                        .background(color = Color.Yellow, shape = CircleShape))
                }


            }
        }
    }
}

@Preview
@Composable
fun Formulari(){
    var escrita by remember { mutableStateOf("") } //variavel para enablar escrever na "caixa"

    // Surface é o espaço("canvas") aonde vão os elementos abaixo


    Column(modifier = Modifier.padding(20.dp),  // dp = "densidade do pixel"?
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {


        TextField(value = escrita, onValueChange = {nova_escrita -> escrita = nova_escrita}, label = {Text(" Comentario...")})

        Spacer(modifier = Modifier.height(10.dp))  // espaçamento entre os textfields


        Button(onClick = {}) {
            Text("ENVIAR")
        }
    }
}



