package model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Champion(
    @StringRes val nameRes: Int,
    @DrawableRes val imageRes: Int
)