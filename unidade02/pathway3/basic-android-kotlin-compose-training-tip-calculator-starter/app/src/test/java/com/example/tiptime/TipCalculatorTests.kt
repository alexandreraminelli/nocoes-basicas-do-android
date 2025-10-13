package com.example.tiptime

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

// Teste local
class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00

        /** Saída esperada. */
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        /** Saída da função. */
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, false)

        assertEquals(expectedTip, actualTip) // verificar se resultado é igual ao esperado


    }
}