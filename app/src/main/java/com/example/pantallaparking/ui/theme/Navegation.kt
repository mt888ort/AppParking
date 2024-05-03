// Navegacion.kt
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navegacionaplimovil.CerrarSessionScreen
import com.example.navegacionaplimovil.IniciarSesion
import com.example.navegacionaplimovil.MapaScreen
import com.example.navegacionaplimovil.Menu
import com.example.navegacionaplimovil.MenuPrincipal
import com.example.navegacionaplimovil.PantallaInicial
import com.example.navegacionaplimovil.Registrarse
import com.example.navegacionaplimovil.RegistrationScreen
import com.example.navegacionaplimovil.ReservarScreen
import com.example.navegacionaplimovil.Actualizar

enum class Pantallas(val route: String) {
    Inicio("inicio"),
    IniciarSesion("iniciarSesion"),
    Registrarse("registrarse"),
    Menu("Menu"),
    MenuPrincipal("menuPrincipal"),
    Reservar("reservar"),
    CerrarSesion("cerrarSesion"),
    RegistrationScreen("registrationScreen"),
    Actualizar("actualizar"),
    Mapa("mapa")
}

@Composable
fun Navegacion() {
    val navHostController = rememberNavController()
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
    NavHost(navController = navHostController, startDestination = Pantallas.Inicio.route) {
        composable(route = Pantallas.Inicio.route) {
            PantallaInicial(navController = navHostController)
        }
        composable(route = Pantallas.IniciarSesion.route) {
            IniciarSesion(navController = navHostController)
        }
        composable(route = Pantallas.Registrarse.route) {
            Registrarse(navController = navHostController)
        }
        composable(route = Pantallas.MenuPrincipal.route) {
            MenuPrincipal(navController = navHostController)
        }
        composable(route = Pantallas.Menu.route) {
            Menu(navController = navHostController)
        }
        composable(route = Pantallas.RegistrationScreen.route) {
            RegistrationScreen(navController = navHostController)
        }
        composable(route = Pantallas.Actualizar.route) {
            Actualizar(navController = navHostController)
        }
        composable(route = Pantallas.Reservar.route) {
            ReservarScreen(navController = navHostController, parkingSpaces = parkingSpaces)
        }
        composable(route = Pantallas.CerrarSesion.route) {
            CerrarSessionScreen(navController = navHostController)
        }
        composable(route = Pantallas.Mapa.route) {
            MapaScreen(navController = navHostController, parkingSpaces = parkingSpaces)
        }
    }
}