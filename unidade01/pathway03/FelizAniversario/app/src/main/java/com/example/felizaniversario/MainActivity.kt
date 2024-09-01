package com.example.felizaniversario

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.felizaniversario.ui.theme.FelizAniversárioTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FelizAniversárioTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    GreetingText(
                        mensagem  = "Feliz Aniversário, Sam!",
                        remetente = "Alexandre",
                        modifier  = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

// Função combinável que descreve elemento Text
@Composable
fun GreetingText(
    mensagem: String,   // mensagem a ser exibida na tela
    remetente: String,  // nome da pessoa que enviou o cartão
    modifier: Modifier = Modifier
) {
    Column( // exibir elementos verticalmente
        verticalArrangement = Arrangement.Center,   // centralizar os elementos verticalmente
        modifier = modifier
    ) {
        // Texto da mensagem
        Text(
            text = mensagem,                // mensagem exibida na tela
            fontSize = 40.sp,               // tamanho da fonte
            lineHeight = 45.sp,             // altura da linha
            textAlign = TextAlign.Center    // centralizar o texto
        )
        // Texto do remetente
        Text(
            text = "- de $remetente",   // mensagem exibida na tela
            fontSize = 20.sp,           // tamanho da fonte
            modifier = Modifier
                .padding(16.dp)         // padding de 16dp em volta do conteúdo
                .align(alignment = Alignment.End)  // alinhar à direita
        )
    }
}

// Função combinável de visualização (preview)
@Preview(showBackground = true)
@Composable
fun PreviaCartaoDeAniversario() {
    FelizAniversárioTheme {
    GreetingText(
        mensagem  = "Feliz Aniversário, Sam!",
        remetente = "Alexandre",
        modifier  = Modifier
    )
    }
}