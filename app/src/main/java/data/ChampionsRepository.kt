package data

import com.example.lolchampions.R
import model.Champion

object ChampionsRepository {
    val champions = listOf(
        Champion(
            nameRes = R.string.kaisa,
            imageRes = R.drawable.kaisa
        )
    )
}
