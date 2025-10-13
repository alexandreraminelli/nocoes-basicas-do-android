package com.example.galeriadearte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 28.dp)
            .fillMaxHeight()
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
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp), // espaçamento entre os botões
        modifier = Modifier,
    ) {
        val buttonModifier = Modifier.weight(1f)

        // Botão de voltar
        ControllerButton(
            label = stringResource(R.string.previous),
            onClick = {
                // TODO: imagem anterior
            },
            modifier = buttonModifier,
        )
        // Botão de avançar
        ControllerButton(
            label = stringResource(R.string.next),
            onClick = {
                // TODO: próxima imagem
            },
            modifier = buttonModifier,
        )
    }
}

/** Botão do controlador. */
@Composable
fun ControllerButton(
    onClick: () -> Unit,
    label: String,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
    ) {
        Text(label)
    }
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