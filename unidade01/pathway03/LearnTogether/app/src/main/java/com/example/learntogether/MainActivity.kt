package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTogetherTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier
) {
// Organizar elementos em colunas
    Column(
        modifier = modifier.fillMaxSize(),
        // Alinhar elementos no topo
        verticalArrangement = Arrangement.Top
    ) {
        // Obter recurso de imagem
        val imagem = painterResource(R.drawable.bg_compose_background)
        // Chamar função combinável que exibe a imagem
        GreetingImageIntroduction(
            image = imagem
        )

        // Exibir título
        Text(
            // Texto exibido
            text = stringResource(R.string.titulo),
            // Tamanho da fonte
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp) // Padding de 16dp
        )

        // Parágrafo 1
        Text(
            // Texto exibido
            text = stringResource(R.string.paragrafo1),
            // Tamanho da fonte
            fontSize = 16.sp,
            // Alinhamento do texto: justificado
            textAlign = TextAlign.Justify,

            modifier = Modifier
                // Padding de 16dp
                .padding(16.dp)
        )
        // Parágrafo 2
        Text(
            // Texto exibido
            text = stringResource(R.string.paragrafo2),
            // Tamanho da fonte
            fontSize = 16.sp,
            // Alinhamento do texto: justificado
            textAlign = TextAlign.Justify,

            modifier = Modifier
                // Padding de 16dp
                .padding(16.dp)
        )

    }

}

/**
 * Função combinável que exibe a imagem no topo
 */
@Composable
fun GreetingImageIntroduction(
    // Receber recurso de imagem
    image: Painter,
    modifier: Modifier = Modifier
) {
// Exibir imagem
    Image(
        // Recurso da imagem
        painter = image,
        contentDescription = null,
        modifier = Modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        Greeting()
    }
}