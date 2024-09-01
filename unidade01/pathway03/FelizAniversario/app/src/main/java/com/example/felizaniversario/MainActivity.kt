package com.example.felizaniversario

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
import com.example.felizaniversario.ui.theme.FelizAniversárioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FelizAniversárioTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                }
            }
        }
    }
}

// Função combinável que descreve elemento Text
@Composable
fun GreetingText(
    mensagem: String,
    modifier: Modifier = Modifier
) {
    Text(text = mensagem)
}

// Função combinável de visualização (preview)
@Preview(showBackground = true)
@Composable
fun PreviaCartaoDeAniversario() {
    FelizAniversárioTheme {
    GreetingText("Feliz Aniversário, Sam!")
    }
}