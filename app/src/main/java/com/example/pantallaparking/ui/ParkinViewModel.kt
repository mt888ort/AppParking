package com.example.pantallaparking.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navegacionaplimovil.CerrarSessionScreen
import com.example.navegacionaplimovil.MapaScreen
import com.example.navegacionaplimovil.PantallaInicial
import com.example.navegacionaplimovil.ReservarScreen
import com.example.pantallaparking.ui.theme.PantallaParkingTheme

class ParkingViewModel : ViewModel() {
    val parkingSpaces = mutableStateListOf<Boolean>(false, false, true, false, true, false, true, true, false, false)
}

class MainActivity : ComponentActivity() {

}

class IniciarSesionViewModel : ViewModel() {
    val usuario = mutableStateOf("")
    val contrasena = mutableStateOf("")
}

class RegistrarseViewModel : ViewModel() {
    val usuario = mutableStateOf("")
    val contrasena = mutableStateOf("")
    val confirmarContrasena = mutableStateOf("")
}
