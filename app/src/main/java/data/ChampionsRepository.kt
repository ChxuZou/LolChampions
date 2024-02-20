package data

import com.example.lolchampions.R
import model.Champion

object ChampionsRepository {
    val champions = listOf(
        Champion(
            nameRes = R.string.kaisa_name,
            imageRes = R.drawable.kaisa,
            regionRes = R.string.kaisa_region
        )
    )
}
