package com.example.quadrantesdocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quadrantesdocompose.ui.theme.QuadrantesDoComposeTheme

/**
 * Classe MainActivity.
 * Herdeira de Component Activity.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadrantesDoComposeTheme {
                Scaffold(
                    modifier = Modifier // Modificador
                        .fillMaxSize()  // Preencher a tela inteira
                ) { innerPadding ->

                    // Chamar função combinável Greeting()
                    Greeting(
                        modifier = Modifier     // Modificador
                            .padding(innerPadding)  // Adicionar padding interno
                    )
                }
            }
        }
    }
}

/**
 * Função combinável Greeting.
 * Exibe na tela o conteúdo da interface.
 *
 * @param modifier Modificador.
 */
@Composable
fun Greeting(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize() // Preencher a tela inteira
    ) {
        // Modificadores pras Rows
        val modificadorRow = Modifier
            .weight(1f) // Preencher toda a width da tela

        // Row dos Elementos
        Row(
            modifier = modificadorRow
        ) {
            /* Elementos da Row */
            // Text card
            val tituloText = stringResource(R.string.text_title)
            val descricaoText = stringResource(R.string.text_paragraph)
            val backgroundText = Color(0xFFEADDFF)
            CardInformativo(
                titulo = tituloText,
                descricao = descricaoText,
                backgroundColor = backgroundText
            )

            // Image card
            val tituloImage = stringResource(R.string.image_title)
            val descricaoImage = stringResource(R.string.image_paragraph)
            val backgroundImage = Color(0xFFD0BCFF)
            CardInformativo(
                titulo = tituloImage,
                descricao = descricaoImage,
                backgroundColor = backgroundImage
            )
        }
        // Row dos tipos de Layout
        Row(
            modifier = modificadorRow
        ) {
            /* Elementos da Row */

            // Row card
            val tituloRow = stringResource(R.string.row_title)
            val descricaoRow = stringResource(R.string.row_paragraph)
            val backgroundRow = Color(0xFFB69DF8)
            CardInformativo(
                titulo = tituloRow,
                descricao = descricaoRow,
                backgroundColor = backgroundRow
            )

            // Column card
            val tituloColumn = stringResource(R.string.column_title)
            val descricaoColumn = stringResource(R.string.column_paragraph)
            val backgroundColumn = Color(0xFFF6EDFF)
            CardInformativo(
                titulo = tituloColumn,
                descricao = descricaoColumn,
                backgroundColor = backgroundColumn
            )
        }
    }
}

/**
 * Função combinável que exibe um card informativo.
 *
 * @param titulo Título do card.
 * @param descricao Texto descritivo do card.
 * @param backgroundColor Cor de fundo do card.
 * @param modifier Modificador.
 */
@Composable
fun CardInformativo(
    titulo: String,
    descricao: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        /* Propriedades da Column */
        // Alinhamentos dos filhos
        verticalArrangement = Arrangement.Center, // Vertical: Centralizar
        horizontalAlignment = Alignment.CenterHorizontally, // Horizontal: Centralizar
        // Modificadores
        modifier = modifier
            .background(backgroundColor) // Background: Cor de fundo
            .padding(16.dp) // Padding: 16dp
            .fillMaxSize() // Preencher toda a width da tela
    ) {
        /* Elementos do Card Informativo */
        TituloCard(titulo)
        descricaoCard(descricao)
    }
}

/**
 *  Função combinável que exibe um título de card.
 *
 *  @param titulo Título a ser exibido.
 *  @param modifier Modificador.
 */
@Composable
fun TituloCard(
    titulo: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = titulo,
        // Tipografia
        fontSize = 16.sp,    // Tamanho da fonte: 16sp
        fontWeight = FontWeight.Bold, // Peso da fonte: Negrito
    )
}

/**
 * Função combinável que exibe um texto descritivo pro card.
 *
 *
 */
@Composable
fun descricaoCard(
    descricao: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = descricao,
        // Tipografia
        textAlign = TextAlign.Justify // Alinhamento do texto: Justificado
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuadrantesDoComposeTheme {
        Greeting()
    }
}