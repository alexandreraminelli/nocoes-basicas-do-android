package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/** Classe de afirmação. */
data class Affirmation(
    /** ID para o texto da afirmação armazenado em um recurso de string. */
    @StringRes val stringResourceId: Int,
    /** ID para a imagem da afirmação armazenada em um recurso drawable. */
    @DrawableRes val imageResourceId: Int
)
