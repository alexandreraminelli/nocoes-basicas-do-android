package com.example.quadrantesdocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    Text(
        text = "Aplicativo Quadrantes do Compose!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuadrantesDoComposeTheme {
        Greeting()
    }
}