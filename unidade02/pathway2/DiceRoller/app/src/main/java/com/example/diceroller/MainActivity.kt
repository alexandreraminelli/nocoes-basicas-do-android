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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    /** Variável de estado do número sorteado do dado. */
    var result by remember { mutableStateOf(1) }

    /** Imagem do dado com base no número sorteado. */
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        6 -> R.drawable.dice_6
        else -> R.drawable.dice_1
    }

    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        // imagem do dado
        Image(
            painter = painterResource(imageResource),
            contentDescription = "Dado exibindo o número $result"
        )
        // espaçamento entre imagem e botão
        Spacer(modifier = Modifier.height(16.dp))
        // botão de rolar dados
        Button(onClick = {
            // Atualizar variável de estado e, consequentemente, realiza uma atualização na tela
            result = (1..6).random() // sortear número entre 1 e 6
        }) {
            Text(stringResource(R.string.roll))
        }
    }
}