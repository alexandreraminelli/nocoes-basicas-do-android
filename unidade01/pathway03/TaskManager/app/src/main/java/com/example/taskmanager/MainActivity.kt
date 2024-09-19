package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Obter recurso de imagem
                    val iconeConcluido = painterResource(R.drawable.ic_task_completed)

                    // Obter recursos de string
                    val msgConcluido = stringResource(R.string.msg_tarefas_concluidas)
                    val msgParabens = stringResource(R.string.msg_parabens)

                    // Chamar função combinável
                    GreetingMsgTarefasConcluidas(
                        icone = iconeConcluido, // Recurso do ícone
                        textoDestaque = msgConcluido, // Texto de destaque
                        textoSubtitulo = msgParabens, // Texto subtitulo
                        modifier = Modifier // Modificador
                            .padding(innerPadding)   // Adicionar padding interno
                    )
                }
            }
        }
    }
}

/**
 * Função combinável que exibe uma mensagem no centro da tela com um ícone.
 *
 * @param icone O painter do recurso que será exibido no topo da mensagem.
 * @param textoDestaque O texto que será exibido no topo da mensagem com ênfase.
 * @param textoSubtitulo O texto que será exibido abaixo do textoDestaque com menos ênfase.
 */
@Composable
fun GreetingMsgTarefasConcluidas(
    // Elementos da tela
    icone: Painter,
    textoDestaque: String,
    textoSubtitulo: String,
    // Modificador
    modifier: Modifier = Modifier
) {
    // Organizar os elementos em um layout de coluna
    Column(
        // Modificadores
        modifier = modifier
            .fillMaxSize(),  // coluna preencher toda a tela
        // Alinhamento dos filhos
        verticalArrangement = Arrangement.Center,   // alinhamento vertical: centralizado
        horizontalAlignment = Alignment.CenterHorizontally  // alinhamento horizontal: centralizado
    ) {
        // Exibir ícone na tela
        GreetingIcone(icone)

        // Exibir texto de destaque na tela
        GreetingTextoDestaque(textoDestaque)

        // Exibir texto normal da mensagem.
        GreetingTexto(textoSubtitulo)
    }
}

/**
 *  Função combinável que exibe o ícone na tela.
 *
 *  @icone Recurso drawable do ícone a ser exibido.
 */
@Composable
fun GreetingIcone(
    icone: Painter
) {
    Image(
        painter = icone,    // obter recurso do ícone
        // Descrição do ícone
        contentDescription = stringResource(R.string.icone_concluido_desc),
        // Modificadores
        modifier = Modifier
            .size(200.dp)   // Tamanho do ícone: 250dp
    )
}

/**
 * Função combinável que exibe texto com destaque na tela.
 *
 * @param texto O texto a ser exibido.
 */
@Composable
fun GreetingTextoDestaque(
    texto: String
) {
    Text(
        text = texto,   // texto a ser exibido
        // Tipografia
        fontSize = 24.sp,    // tamanho da fonte: 24sp
        fontWeight = FontWeight.Bold,   // peso da fonte: bold (negrito)
        // Alinhamento
        textAlign = TextAlign.Center,   // alinhamento: centralizado
        // Modificadores
        modifier = Modifier
            .padding(   // Adicionar padding
                top = 24.dp,    // padding-top: 24dp
                bottom = 8.dp   // padding-bottom: 8dp
            )
    )
}

/**
 * Função combinável que exibe texto normal na tela.
 *
 * @param texto O texto a ser exibido.
 */
@Composable
fun GreetingTexto(
    texto: String
) {
    Text(
        text = texto,   // texto a ser exibido
        // Tipografia
        fontSize = 16.sp,    // tamanho da fonte: 16sp
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        // Obter recurso de imagem
        val iconeConcluido = painterResource(R.drawable.ic_task_completed)

        // Obter recursos de string
        val msgConcluido = stringResource(R.string.msg_tarefas_concluidas)
        val msgParabens = stringResource(R.string.msg_parabens)

        // Chamar função combinável
        GreetingMsgTarefasConcluidas(
            icone = iconeConcluido, // Recurso do ícone
            textoDestaque = msgConcluido, // Texto de destaque
            textoSubtitulo = msgParabens, // Texto subtitulo
            modifier = Modifier // Modificador
        )
    }
}