package com.example.conviteaniversario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.conviteaniversario.ui.theme.ConviteDeAniversárioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConviteDeAniversárioTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier) {
    Surface(
        color = Color.Red // Cor de fundo do texto
    ) {
        Text(
            text = "Oi, meu nome é $name!",     // Texto exibido na tela
            modifier = modifier.padding(24.dp)  // Padding do texto
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConviteDeAniversárioTheme {
        Greeting("Meghan")
    }
}