package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize() // ocupar toda a tela
            .wrapContentSize(Alignment.Center) //
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    /** Resultado do dado. */
    var result = 1

    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        // imagem do dado
        Image(
            painter = painterResource(R.drawable.dice_1),
            contentDescription = "Dado exibindo o número 1"
        )
        // espaçamento entre imagem e botão
        Spacer(modifier = Modifier.height(16.dp))
        // botão de rolar dados
        Button(onClick = {
            result = (1..6).random() // sortear número entre 1 e 6
        }) {
            Text(stringResource(R.string.roll))
        }
    }
}