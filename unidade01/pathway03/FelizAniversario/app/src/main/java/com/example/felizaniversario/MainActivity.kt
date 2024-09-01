package com.example.felizaniversario

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
                    // Chamar a função combinável para renderizar a UI
                    GreetingImage(
                        mensagem = "Feliz Aniversário, Sam!",
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

// Função combinável que exibe imagem
@Composable
fun GreetingImage(
    mensagem: String,   // mensagem de aniversário
    remetente: String,  // remetente do cartão
    // parâmetro Modifier opcional (para todas as funções combináveis)
    modifier: Modifier = Modifier   // como os elementos serão dispostos
) {
    // Acessar uma imagem do recurso (androidparty.png)
    val imagem = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(  // imagem decorativa
            painter = imagem,           // imagem a ser exibida
            contentDescription = null,   // imagem decorativa (não precisa de descrição)
            contentScale = ContentScale.Crop,   // ajuste de escala para a imagem preencher tudo
        )

        GreetingText(
            mensagem = mensagem,
            remetente = remetente,
            modifier = Modifier
                .fillMaxSize()  // preencher toda a tela
                .padding(8.dp)  // padding de 8dp em volta do conteúdo
        )
    }
}

// Função combinável de pré-visualização (preview)
@Preview(showBackground = true)
@Composable
fun PreviaCartaoDeAniversario() {
    FelizAniversárioTheme {
        GreetingImage(
            mensagem = "Feliz Aniversário, Sam!",
            remetente = "Alexandre"
        )
    }
}