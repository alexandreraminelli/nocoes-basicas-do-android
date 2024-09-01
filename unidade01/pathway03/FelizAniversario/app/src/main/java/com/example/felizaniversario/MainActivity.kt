package com.example.felizaniversario

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                        remetente = "Alexandre"
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
        modifier = modifier // transmitir parâmetro modificador aos elementos filhos
    ) {
        // Primeiro texto
        Text(
            text = mensagem,        // mensagem exibida na tela
            fontSize = 30.sp,       // tamanho da fonte
            lineHeight = 116.sp,    // altura da linha
        )
        // Segundo texto
        Text(
            text = "- de $remetente",   // mensagem exibida na tela
            fontSize = 20.sp            // tamanho da fonte
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
        remetente = "Alexandre"
    )
    }
}