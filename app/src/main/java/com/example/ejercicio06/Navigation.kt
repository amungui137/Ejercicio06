package com.example.ejercicio06

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.ejercicio06.model.Routes

@Composable
fun MyNavigation() {
    val navigationController = rememberNavController()
    NavHost(
        navController = navigationController,
        startDestination = Routes.pantalla1.route
    ) {
        composable(Routes.pantalla1.route) { Screen1(navigationController) }
        composable(Routes.pantalla2.route) { Screen2(navigationController) }
        composable(Routes.pantalla3.route) { Screen3(navigationController) }
        composable(
            Routes.pantalla4.route,
            arguments = listOf(navArgument("age") { type = NavType.IntType })
        ) {backStackEntry ->
            Screen4(navigationController, backStackEntry.arguments?.getInt("age")?: 0)
        }
        composable(
            Routes.pantalla5.route,
            arguments = listOf(navArgument("name") { defaultValue = "Manuel" })
        ) {backStackEntry ->
            Screen5(navigationController, backStackEntry.arguments?.getString("name"))
        }

    }
}

@Composable
fun Screen1(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .background(Color.Cyan)
            .fillMaxSize(),
    ) {
        Text(text = "Pantalla 1",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.pantalla2.route) })
    }
}

@Composable
fun Screen2(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .fillMaxSize(),
    ) {
        Text(text = "Pantalla 2",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.pantalla3.route) })
    }
}

@Composable
fun Screen3(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .background(Color.Red)
            .fillMaxSize(),
    ) {
        Text(
            text = "Pantalla 3",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.pantalla4.createRoute(25)) })
    }
}

@Composable
fun Screen4(navigationController: NavHostController, age: Int) {
    Box(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxSize(),
    ) {
        Text(
            text = "Tengo $age años",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.pantalla5.route) })
    }
}

@Composable
fun Screen5(navigationController: NavHostController, name: String?) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
    ) {
        Text(
            text = "Me llamo $name",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.pantalla1.route) })
    }
}