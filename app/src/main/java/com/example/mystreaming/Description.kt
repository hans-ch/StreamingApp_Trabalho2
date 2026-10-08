package com.example.mystreaming

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalhesScreen(
    navController: NavHostController,
    filme: MediaItem = sampleMediaList.first()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Segunda Tela") },
                // navigationIcon = ícone à ESQUERDA da barra (padrão: botão voltar)
                navigationIcon = {   // ← MUDOU: seta de voltar na barra (não tem mais botão no corpo)
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { padding ->
        // Organiza os elementos de cima para baixo.
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1E2A78))
                .safeDrawingPadding()
                .padding(20.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            // Coloca o bloco preto e o título lado a lado.
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Box(
                    modifier = Modifier
                        .width(120.dp)
                        .height(180.dp)
                        .background(Color.Black)
                ) {
                    Text(
                        text = "+",
                        color = Color.White,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(4.dp)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = filme.title,
                        fontSize = 24.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "14",
                            fontSize = 12.sp,
                            color = Color.White,
                            modifier = Modifier
                                .background(Color(0xFFFF9800))
                                .padding(2.dp)
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = filme.year,
                            fontSize = 12.sp,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = filme.rating,
                            fontSize = 12.sp,
                            color = Color.Black
                        )

                        Text(
                            text = "★",
                            fontSize = 12.sp,
                            color = Color.Yellow
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Sed do eiusmod tempor incididunt ut labore et dolore magna " +
                        "aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
                        "ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                        "Duis aute irure dolor in reprehenderit in voluptate velit " +
                        "esse cillum dolore eu fugiat nulla pariatur.",
                fontSize = 10.sp,
                lineHeight = 12.sp,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TelaDetalhesPreview(){
    MaterialTheme{
        DetalhesScreen(navController = rememberNavController())
    }
}