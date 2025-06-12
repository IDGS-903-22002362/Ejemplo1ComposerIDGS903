package com.lrosas.ejemplo1composeridgs903

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val tarjetas: List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta(
        "A 16",
        "Android 16 es un androide gigante conocido por su amor a la naturaleza y la vida"
    ),
    PersonajeTarjeta(
        "Bardock",
        "Es un saiyano de clase baja proveniente del Planeta Vegeta del Universo 7"
    ),
    PersonajeTarjeta(
        "Janemba",
        "Janemba es un demonio de pura maldad y gran poder maligno. Creado a partir de las acciones de un adolescente ogro llamado Psyche Oni"
    ),
    PersonajeTarjeta(
        "Gotenks",
        "Gotenks también conocido inicialmente como Gotrunk en el doblaje al español de España"
    ),
    PersonajeTarjeta(
        "Ginyu",
        "Ginyu es el líder del la élite de mercenarios de mayor prestigio del Ejército de Freeza"
    )
)

data class PersonajeTarjeta(val title: String, val body: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
        Ejemplo1ComposerIDGS903Theme {
            Tarjeta(tarjetas)
        }

        }
    }
}

@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>){
    LazyColumn {
        //ImagenHeroe()
        items(personajes){personaje ->

            Mypersonaje(personaje)
        }
    }
}

@Composable
fun Mypersonaje(personaje: PersonajeTarjeta) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Row(
            modifier = Modifier.padding(8.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {
            ImagenHeroe()
            Personajes(personaje)
        }
    }

}

@Composable
fun Personaje(name:String, color: Color, style:TextStyle){
    Text(text = name)
}

@Composable
fun Personajes(personaje: PersonajeTarjeta){
    Column {
        Personaje(personaje.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.headlineMedium)

        Personaje(personaje.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun ImagenHeroe(){
    Image(
        painter = painterResource(R.drawable.goku),
        contentDescription = "Goku",
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.tertiary)
    )
}


@Preview
@Composable
fun GreetingPreview(){
    Tarjeta(tarjetas)
}