package com.example.galeriadearte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.galeriadearte.ui.theme.GaleriaDeArteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GaleriaDeArteTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

/** Layout da galeria. */
@Composable
fun ArtSpaceLayout(
    modifier: Modifier = Modifier

) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 28.dp)
    ) {
        // Parede de obras de arte
        ArtworkWall()

        // Descritor de obras de arte
        ArtworkDescription()

        // Controlador de exibição
        DisplayController()
    }
}

/** Parede de obras de artes. Exibe a imagem da obra de arte. */
@Composable
fun ArtworkWall(
    modifier: Modifier = Modifier
) {
    Text("Parede de obras de arte")
}

/** Descrição da obra de arte. Nome da obra de arte, artista e ano.*/
@Composable
fun ArtworkDescription(
    modifier: Modifier = Modifier
) {
    Text("Descrição da obra de arte")
}

/** Controlador de exibição. Botões de avançar e voltar para navegar entre as obras de arte. */
@Composable
fun DisplayController(
    modifier: Modifier = Modifier
) {
    Text("Controlador de exibição")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GaleriaDeArteTheme {
        GaleriaDeArteTheme {
            ArtSpaceLayout()
        }
    }
}