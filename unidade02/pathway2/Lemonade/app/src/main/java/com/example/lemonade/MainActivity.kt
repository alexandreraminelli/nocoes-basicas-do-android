package com.example.lemonade

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LemonadeApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    /** Etapa do processo. */
    var step by remember { mutableStateOf(1) }

    /** Texto de instruções da etapa. */
    val instruction = when (step) {
        1 -> R.string.first_step_instructions
        2 -> R.string.second_step_instructions
        3 -> R.string.third_step_instructions
        4 -> R.string.fourth_step_instructions
        else -> R.string.first_step_instructions
    }

    /** Imagem da etapa. */
    val image = when (step) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.ic_launcher_background
    }

    /** Descrição da imagem da etapa. */
    val imgDesc = when (step) {
        1 -> R.string.first_step_img
        2 -> R.string.second_step_img
        3 -> R.string.third_step_img
        4 -> R.string.fourth_step_img
        else -> R.string.first_step_img
    }

    /** Quantidade de vezes que precisa expremer o limão. */
    val squeezeNum = (2..4).random()

    /** Contador de quantas vezes clicou no limão. */
    var squeezeCont = 0

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagem do limão
        Button(
            onClick = {
                if (step == 2) {
                    squeezeCont++
                    if (squeezeCont == squeezeNum) {
                        step++
                    }
                } else if (step < 4) {
                    step++
                } else {
                    step = 1
                }
            }
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = stringResource(imgDesc)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            stringResource(instruction),
            style = TextStyle(fontSize = 18.sp)
        )

    }
}