package com.unisangil.proyectokidmath

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.unisangil.proyectokidmath.ui.theme.ProyectoKIDMATHTheme
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoKIDMATHTheme {
                    Navegacion()
            }
        }
    }
}

@Composable
fun Navegacion(){//Navega entre las ventanas que componen el prototipo
    val navController = rememberNavController()
    NavHost(navController, startDestination =  "Login" ) {
        composable("Login") {VentanaLogin(navController)}
        composable("Registro") {VentanaRegistro(navController)}
        composable("Inicio") {VentanaInicio(navController)}
        composable("Operaciones"){ VentanaOperaciones(navController)}
        composable("Suma"){ VentanaSuma(navController)}
        composable("Resta"){ VentanaResta(navController)}
        composable("Multiplicacion"){ VentanaMultiplicacion(navController)}
        composable("Division"){ VentanaDivision(navController)}

    }
}
//@Preview(showBackground = true)

@Composable
fun VentanaLogin(navController: NavController) {
    var Usuario by remember { mutableStateOf("") }
    var Contraseña by remember { mutableStateOf("") }
    val context = LocalContext.current //Obtiene la informacion para mostrar el mensaje de Toast

    Scaffold(
        modifier = Modifier.fillMaxSize()//Maxima pantalla
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text("KIDMATH", style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(8.dp))

            Text("Login", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = Usuario,
                onValueChange = { Usuario = it },
                label = { Text("Usuario") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = Contraseña,
                onValueChange = { Contraseña = it },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                //Botón Ingreso
                Button(onClick = {
                    if (Usuario.isBlank() || Contraseña.isBlank()) {
                        Toast.makeText(context, "Complete todos los campos", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Bienvenido a KIDMATH", Toast.LENGTH_SHORT).show()
                        navController.navigate("Inicio")
                    }
                }) {
                    Text("Ingresar")
                }

                // Botón Registrar
                Button(onClick = {
                    navController.navigate("Registro")
                }) {
                    Text("Registrar")
                }

            }
        }
    }
}


@Composable
fun VentanaRegistro(navController: NavController){
    var Cedula by remember { mutableStateOf("") }
    var Nombres by remember { mutableStateOf("") }
    var Apellidos by remember { mutableStateOf("") }
    var Usuario by remember { mutableStateOf("") }
    var Contrasena by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text("KIDMATH", style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(8.dp))

            Text("Registro", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            //Recolector de datos para el registro
            TextField(
                value = Cedula,
                onValueChange = { Cedula = it },
                label = { Text("Cédula") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = Nombres,
                onValueChange = { Nombres = it },
                label = { Text("Nombres") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = Apellidos,
                onValueChange = { Apellidos = it },
                label = { Text("Apellidos") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = Usuario,
                onValueChange = { Usuario = it },
                label = { Text("Usuario") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = Contrasena,
                onValueChange = { Contrasena = it },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            //Boton de registro
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = {
                    if (Cedula.isBlank() || Nombres.isBlank() || Apellidos.isBlank() || Usuario.isBlank() || Contrasena.isBlank()) {
                        Toast.makeText(context, "Complete todos los campos", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Registro exitoso, bienvenido a KIDMATH", Toast.LENGTH_SHORT).show()
                        navController.navigate("Inicio")
                    }
                }) {
                    Text("Registrar")

                }
            }
        }
    }

}

//Desarrollo
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")// Linea obligatoria por problemas con el padding
@Composable
fun VentanaInicio(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "KIDMATH",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "¡Aprende jugando!",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            //Boton vamos!
            Button(onClick = { navController.navigate("operaciones") }) {
                Text("¡Vamos!")
            }
        }
    }
}





//Ventana  de Operaciones basicas
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VentanaOperaciones(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),//Margen para elementos
            verticalArrangement = Arrangement.Center,//Centra los botones de manera vertical
            horizontalAlignment = Alignment.CenterHorizontally //centra en horizontal
        ) {
            Text(
                text = "Selecciona una operación",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            //Botones de la operaciones Basicas de las matematicas
            Button(onClick = { navController.navigate("suma") }) { Text("Suma") }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("resta") }) { Text("Resta") }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("multiplicacion") }) { Text("Multiplicación") }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("division") }) { Text("División") }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("inicio") }) { Text("Volver al Inicio") }
        }
    }
}

//SUMA
@Composable
fun VentanaSuma(navController: NavController) {
    OperacionBasica(
        navController = navController,
        operador = "+",
        operacion = { a, b -> a + b }
    )
}

//RESTA
@Composable
fun VentanaResta(navController: NavController) {
    OperacionBasica(
        navController = navController,
        operador = "-",
        operacion = { a, b -> a - b }
    )
}

//MULTIPLIACION
@Composable
fun VentanaMultiplicacion(navController: NavController) {
    OperacionBasica(
        navController = navController,
        operador = "*",
        operacion = { a, b -> a * b }
    )
}

//DIVISION
@Composable
fun VentanaDivision(navController: NavController) {
    OperacionBasica(
        navController = navController,
        operador = "/",
        operacion = { a, b -> if (b != 0) a / b else 0 }//Evita divisiones entre cero 0
    )
}


//Generador de opciones
fun generateOptions(n1: Int, n2: Int, operacion: (Int, Int) -> Int): List<Int> {
    // Calcula la respuesta correcta
    val respuestaCorrecta = operacion(n1, n2)

    // Conjunto para almacenar las opciones (incluyendo la correcta)
    val opciones = mutableSetOf(respuestaCorrecta)

    // Genera números aleatorios para las opciones incorrectas
    while (opciones.size < 5) {
        val opcionIncorrecta = (0..18).random()
        // Asegúrate de que no sea igual a la correcta
        if (opcionIncorrecta != respuestaCorrecta) {
            opciones.add(opcionIncorrecta)
        }
    }

    // Devuelve las opciones en orden aleatorio
    return opciones.shuffled()
}



//Operaciones basicas
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OperacionBasica(
    navController: NavController,
    operador: String, //operador segun la operacion
    operacion: (Int, Int) -> Int //Logica para calcular el resultado
) {
    var numero1 by remember { mutableStateOf((0..9).random()) }
    var numero2 by remember { mutableStateOf((0..9).random()) }
    var opciones by remember { mutableStateOf(generateOptions(numero1, numero2, operacion)) } //Opcion de respuesta

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Fila que muestra los numeros para las operaciones
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "$numero1", style = MaterialTheme.typography.headlineLarge)
                Text(text = " $operador ", style = MaterialTheme.typography.headlineLarge)
                Text(text = "$numero2", style = MaterialTheme.typography.headlineLarge)
            }

            Spacer(modifier = Modifier.height(32.dp))

            //Generador de botones de respuesta
            opciones.forEach { opcion ->
                val context = LocalContext.current

                Button(onClick = {
                    val mensaje =
                        if (opcion == operacion(numero1, numero2)) "¡Bien hecho!" else "Está mal"
                    Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "$opcion")
                }

                Spacer(modifier = Modifier.height(16.dp))
            }

            //Boton para generar nuevos numeros
            Button(onClick = {
                numero1 = (0..9).random()
                numero2 = (0..9).random()
                opciones = generateOptions(numero1, numero2, operacion)
            }) {
                Text("¡Otra vez!")
            }
            Spacer(modifier = Modifier.height(16.dp))
           // Boton Otra vez!
            Button(onClick = { navController.navigate("operaciones") }) {
                Text("Volver")
            }
        }
    }
}




















