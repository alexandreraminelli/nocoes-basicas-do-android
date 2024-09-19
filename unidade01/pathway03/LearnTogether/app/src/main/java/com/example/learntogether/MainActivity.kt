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
                    // Definir recurso de imagem
                    val imagem = painterResource(R.drawable.bg_compose_background)
                    // Obter recursos de string
                    val titulo = stringResource(R.string.titulo)
                    val paragrafo1 = stringResource(R.string.paragrafo1)
                    val paragrafo2 = stringResource(R.string.paragrafo2)

                    // Exibir conteúdo (imagem de capa + artigo) na tela
                    Greeting(
                        imagemCapa = imagem,
                        tituloArtigo = titulo,
                        paragrafoArtigo1 = paragrafo1,
                        paragrafoArtigo2 = paragrafo2,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/**
 * Exibir conteúdo na tela

 * @param imagemCapa O recurso de imagem que é exibido na tela.
 * @param tituloArtigo O título do artigo exibido abaixo da imagem de capa.
 * @param paragrafoArtigo1 Texto do primeiro parágrafo do artigo.
 * @param paragrafoArtigo2 Texto do segundo parágrafo do artigo.
 */
@Composable
fun Greeting(
    imagemCapa: Painter,
    tituloArtigo: String,
    paragrafoArtigo1: String,
    paragrafoArtigo2: String,
    modifier: Modifier = Modifier
) {
// Organizar elementos em uma coluna
    Column(
        modifier = modifier.fillMaxSize(),
        // Alinhar elementos no topo
        verticalArrangement = Arrangement.Top
    ) {
        // Exibir imagem de capa
        GreetingImageIntroduction(imagemCapa)

        // Exibir artigo
        GreetingArticle(tituloArtigo, paragrafoArtigo1, paragrafoArtigo2)

    }

}

/**
 * Função combinável que exibe a imagem no topo
 */
@Composable
fun GreetingImageIntroduction(
    // Receber recurso de imagem
    image: Painter
) {
// Exibir imagem
    Image(
        // Recurso da imagem
        painter = image,
        contentDescription = null,
        modifier = Modifier
    )
}

/**
 * Função combinável que exibe o artigo
 *
 * @param titulo Título do artigo.
 * @param paragrafo1 Primeiro parágrafo do artigo.
 * @param paragrafo2 Segundo parágrafo do artigo.
 */
@Composable
fun GreetingArticle(
    titulo: String,
    paragrafo1: String,
    paragrafo2: String
) {
    // Exibir título do artigo
    GreetingHeading1(titulo)

    // Exibir parágrafo 1
    GreetingParagrafoArtigo(paragrafo1)

    // Exibir parágrafo 2
    GreetingParagrafoArtigo(paragrafo2)
}

/**
 * Exibir um título nível 1
 *
 * @param titulo Título a ser exibido
 */
@Composable
fun GreetingHeading1(
    titulo: String
) {
    Text(
        text = titulo,      // Texto exibido
        // Tipografia
        fontSize = 24.sp,   // Tamanho da fonte: 24sp
        // Modificadores
        modifier = Modifier
            .padding(16.dp) // Padding de 16dp
    )
}

/**
 * Exibir texto normal de um artigo.
 *
 * @param texto Texto a ser exibido.
 */
@Composable
fun GreetingParagrafoArtigo(
    texto: String
) {
    Text(
        text = texto,                   // Texto exibido
        // Tipografia
        fontSize = 16.sp,               // Tamanho da fonte
        textAlign = TextAlign.Justify,  // Alinhamento do texto: justificado
        // Modificadores
        modifier = Modifier
            .padding(16.dp)             // Padding de 16dp
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        // Definir recurso de imagem
        val imagem = painterResource(R.drawable.bg_compose_background)
        // Obter recursos de string
        val titulo = stringResource(R.string.titulo)
        val paragrafo1 = stringResource(R.string.paragrafo1)
        val paragrafo2 = stringResource(R.string.paragrafo2)

        // Exibir conteúdo (imagem de capa + artigo) na tela
        Greeting(
            imagemCapa = imagem,
            tituloArtigo = titulo,
            paragrafoArtigo1 = paragrafo1,
            paragrafoArtigo2 = paragrafo2,
            modifier = Modifier
        )
    }
}