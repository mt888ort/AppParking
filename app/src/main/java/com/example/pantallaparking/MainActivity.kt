package com.example.navegacionaplimovil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import com.example.pantallaparking.ui.theme.PantallaParkingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaParkingTheme {
                val navController = rememberNavController()
                val parkingSpaces = remember {
                    mutableStateListOf<Boolean>(
                        false,
                        false,
                        true,
                        false,
                        true,
                        false,
                        true,
                        true,
                        false,
                        false
                    )
                }
                NavHost(navController = navController, startDestination = "inicio") {
                    composable("inicio") { PantallaInicial(navController) }
                    composable("reservar") { ReservarScreen(parkingSpaces) }
                    composable("horarios") { CerrarSessionScreen() }
                    composable("mapa") { MapaScreen(parkingSpaces) }
                }
            }
        }
    }
}

@Composable
fun PantallaInicial(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "¡Bienvenido al Parqueadero!",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 40.dp)
            )
            MenuPrincipal(navController = navController)
        }
    }
}

@Composable
fun MenuPrincipal(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(horizontal = 30.dp)
    ) {
        BotonMenu(texto = "Reservar Parqueadero") {
            navController.navigate("reservar")
        }
        BotonMenu(texto = "Ver Mapa") {
            navController.navigate("mapa")
        }
        BotonMenu(texto = "Cerrar Sesion") {
            navController.navigate("Cerrar Sesion")
        }
    }
}

@Composable
fun BotonMenu(texto: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            Color.LightGray,
            contentColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = texto,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun ParkingSpaceButton(isOccupied: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(contentColor = Color.White),
        modifier = Modifier
            .background(if (isOccupied) Color.Red else Color.Black)
            .padding(7.dp)
            .height(70.dp) // Aumenta la altura del botón
    ) {
        Text(text = if (isOccupied) " Ocupado  " else "Disponible")
    }
}

@Composable
fun ReservarScreen(parkingSpaces: MutableList<Boolean>) {
    val columnCount = 3
    val rowCount = parkingSpaces.size / columnCount

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 20.dp) // Agrega un espacio en la parte superior
    ) {
        for (i in 0 until rowCount) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                for (j in 0 until columnCount) {
                    val index = i * columnCount + j
                    val isOccupied = parkingSpaces[index]
                    ParkingSpaceButton(isOccupied = isOccupied, onClick = {
                        // Cambia el estado de ocupado a disponible y viceversa
                        parkingSpaces[index] = !isOccupied
                    })
                }
            }
        }
    }
}

@Composable
fun MapaScreen(parkingSpaces: MutableList<Boolean>) {
    val columnCount = 3
    val rowCount = parkingSpaces.size / columnCount

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        for (i in 0 until rowCount) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                for (j in 0 until columnCount) {
                    val index = i * columnCount + j
                    val isOccupied = parkingSpaces[index]
                    ParkingSpaceBox(isOccupied = isOccupied, modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun ParkingSpaceBox(isOccupied: Boolean, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(if (isOccupied) Color.Red else Color.Green)
            .aspectRatio(0.8f)
            .padding(7.dp)
            .padding(7.dp) // padding alrededor de la caja
            .border(6.dp, Color.Black) // margen negro entre las cajas
    )
}

@Composable
fun CerrarSessionScreen() {
    Card(
        modifier = Modifier
            .padding(14.dp)
            .padding(14.dp),
        shape = RoundedCornerShape(20.dp),
    ) {

    }
}