package com.example.ejercicio06.model

sealed class Routes(val route: String){
    object pantalla1: Routes("pantalla1")
    object pantalla2: Routes("pantalla2")
    object pantalla3: Routes("pantalla3")
    object pantalla4: Routes ("pantalla4/{age}") {
        fun createRoute(age: Int) = "pantalla4/$age"
    }

}