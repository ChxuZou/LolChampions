package model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Ability(
    @DrawableRes val imageRes: Int,
    @StringRes val descriptionRes: Int
)