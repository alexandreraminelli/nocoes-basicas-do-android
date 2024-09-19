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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

                    // Chamar função combinável
                    GreetingMsgTarefasConcluidas(
                        icone = iconeConcluido, // Recurso do ícone
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
 */
@Composable
fun GreetingMsgTarefasConcluidas(
    icone: Painter,
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
        // Função combinável que exibe ícone na tela
        GreetingIcone(icone)
    }
}

/**
 *  Função combinável que exibe o ícone na tela
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
            .size(250.dp)   // Tamanho do ícone: 250dp
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        // Obter recurso de imagem
        val iconeConcluido = painterResource(R.drawable.ic_task_completed)

        // Chamar função combinável
        GreetingMsgTarefasConcluidas(
            icone = iconeConcluido,
            modifier = Modifier
        )
    }
}