package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
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

    /* Variáveis dos ícones */
    val codeIcon = painterResource(R.drawable.code)

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
        // Header
        Header(icon = codeIcon, name = name, carrer = carrer)
        // Escolaridade
        Text(
            text = name,
            modifier = modifier
        )
        // Contato
        Text(
            text = name,
            modifier = modifier
        )
    }
}

/**
 * Cabeçalho do cartão de visitas.
 * @author Alexandre Raminelli
 * @param name Nome no cartão de visitas.
 * @param carrer A profissão do cartão de visitas.
 */
@Composable
fun Header(icon: Painter, name: String, carrer: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, // alinhamento: centralizado
        verticalArrangement = Arrangement.spacedBy(8.dp), // espaçamento: 8px
    ) {
        // Ícone Code
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
        )
        // Nome
        Text(
            text = name,
            fontSize = 36.sp, // font-size: 36px
            fontWeight = FontWeight.Bold, // font-weight: bold
            textAlign = TextAlign.Center, // text-align: center
            modifier = Modifier
        )
        // Profissão
        Text(
            text = carrer,
            fontSize = 22.sp, // font-size: 16px
            textAlign = TextAlign.Center, // text-align: center
            modifier = Modifier
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