package model


data class Champion(
    val nameRes: String,
    val imageRes: String,
    val descriptionRes: String,
    val abilities: MutableList<Ability>
)