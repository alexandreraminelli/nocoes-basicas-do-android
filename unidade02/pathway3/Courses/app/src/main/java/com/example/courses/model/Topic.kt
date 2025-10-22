package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/** Classe de dados com os dados de cada tópico do cursos. */
data class Topic(
    /** ID do recurso com o nome do tópico. */
    @StringRes val nameResourceId: Int,
    /** Quantidade de cursos. */
    val quant: Int,
    /** ID do recurso da imagem do curso. */
    @DrawableRes val imageResourceId: Int,
)
