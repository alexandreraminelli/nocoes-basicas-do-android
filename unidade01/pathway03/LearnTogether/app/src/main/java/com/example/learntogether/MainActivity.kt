package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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
    Column {
        // Obter recurso de imagem
        val imagem = painterResource(R.drawable.bg_compose_background)
        // Exibir imagem
        Image(
            painter = imagem,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        Greeting()
    }
}