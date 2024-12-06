package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /* Chamar a função combinável */
                    GreetingBusinessCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/**
 * Função combinável que renderiza a UI do cartão de visitas.
 * @author Alexandre Raminelli
 * @param modifier Modificadores para personalizar a UI.
 */
@Composable
fun GreetingBusinessCard(
    modifier: Modifier = Modifier
) {
    /* Variáveis dos recursos de strings */
    val name = stringResource(R.string.user_name)
    val carrer = stringResource(R.string.carrer)
    val education = stringResource(R.string.education)
    val phone = stringResource(R.string.phone)
    val email = stringResource(R.string.email)
    val linkedin = stringResource(R.string.linkedin)
    val github = stringResource(R.string.github)

    /* layout da página */
    Column(
        // layout
        horizontalAlignment = Alignment.CenterHorizontally, // alinhamento horizontal: centralizado
        verticalArrangement = Arrangement.SpaceBetween, // alinhamento vertical: space-beetween
        // Modificadores
        modifier = modifier
            .fillMaxSize() // Preencher toda a tela
            .padding( // espaçamento
                start = 16.dp, end = 16.dp, top = 160.dp, bottom = 40.dp
            )

    ) {
        Text(
            text = name,
            modifier = modifier
        )
        Text(
            text = name,
            modifier = modifier
        )
        Text(
            text = name,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        /* Chamar a função combinável */
        GreetingBusinessCard()
    }
}