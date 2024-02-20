package data

import com.example.lolchampions.R
import model.Ability
import model.Champion

object ChampionsRepository {
    val champions = listOf(
        Champion(
            nameRes = R.string.kaisa_name,
            imageRes = R.drawable.kaisa,
            descriptionRes = R.string.kaisa_description,
            abilities = listOf(
                Ability(
                    imageRes = R.drawable.kaisa_ability1,
                    descriptionRes = R.string.kaisa_ability1_description
                ),
                Ability(
                    imageRes = R.drawable.kaisa_ability2,
                    descriptionRes = R.string.kaisa_ability2_description
                ),
                Ability(
                    imageRes = R.drawable.kaisa_ability3,
                    descriptionRes = R.string.kaisa_ability3_description
                ),Ability(
                    imageRes = R.drawable.kaisa_ability4,
                    descriptionRes = R.string.kaisa_ability4_description
                )
            )
        )
    )
}
