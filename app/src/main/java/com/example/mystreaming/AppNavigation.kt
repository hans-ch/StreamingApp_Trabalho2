package com.example.mystreaming

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    // 1. Cria o controlador de navegação (pilha de telas)
    val navController = rememberNavController()

    // 2. Define o mapa de rotas do app
    NavHost(
        navController = navController,
        startDestination = Rotas.HOME   // tela que abre primeiro
    ) {
        composable(Rotas.HOME) {
            HomeScreen(
                navController = navController,
                //viewModel = viewModel          // ← MUDOU: parâmetro novo, passa o VM
            )
        }

        composable(Rotas.SEGUNDA) {
            DetalhesScreen(
                navController = navController,
                //viewModel = viewModel          // ← MUDOU: parâmetro novo, mesmo VM!
            )
        }

    }
}