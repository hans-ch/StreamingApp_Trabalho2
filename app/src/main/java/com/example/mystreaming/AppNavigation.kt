package com.example.mystreaming

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    // Guarda o ID do filme escolhido.
    var filmeId by rememberSaveable {
        mutableStateOf(sampleMediaList.first().id)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
    ) {
        NavHost(
            navController = navController,
            startDestination = Rotas.HOME,
            modifier = Modifier.weight(1f)
        ) {
            composable(Rotas.HOME) {
                HomeScreen(
                    navController = navController,
                    onFilmeClick = { filme ->
                        filmeId = filme.id
                        navController.navigate(Rotas.SEGUNDA)
                    }
                )
            }

            composable(Rotas.SEGUNDA) {
                DetalhesScreen(
                    navController = navController,
                    filme = sampleMediaList.first { it.id == filmeId }
                )
            }

            composable(Rotas.COMENTARIOS){
                ComentariosScreen(
                    navController = navController,
                    filme = sampleMediaList.first{ it.id == filmeId }
                )
            }

            composable("perfil") {
                ProfileScreen()
            }
        }

        // Apenas Início e Perfil na barra inferior.
        Row(modifier = Modifier.fillMaxWidth()) {
            TextButton(
                onClick = {
                    navController.popBackStack(Rotas.HOME, false)
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Início")
            }

            TextButton(
                onClick = {
                    navController.navigate("perfil") {
                        launchSingleTop = true
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Perfil")
            }
        }
    }
}
