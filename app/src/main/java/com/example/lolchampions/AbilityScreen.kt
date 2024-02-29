package com.example.lolchampions

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import model.Ability
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.lolchampions.ui.theme.LolChampionsTheme
import kotlinx.coroutines.delay

@Composable
fun AbilityList(championAbilities: List<Ability>, modifier: Modifier = Modifier) {
    var selectedAbility by remember { mutableStateOf(-1) }

    Column(
        modifier = Modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        LazyRow(modifier = modifier) {
            itemsIndexed(championAbilities) { index, ability ->
                AbilityIcon(ability = ability) {
                    if (selectedAbility == index) {
                        selectedAbility = -1
                    } else {
                        selectedAbility = index
                    }
                }
                Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)))
            }
        }

        if (selectedAbility != -1) {
            AbilityInformation(modifier, championAbilities[selectedAbility].descriptionRes)
        }
    }
}

@Composable
fun AbilityInformation(modifier: Modifier = Modifier, descriptionRes: String) {
    SlowTypeWriterAnimation( descriptionRes, modifier = modifier)
}

@Composable
fun SlowTypeWriterAnimation(text: String, modifier: Modifier = Modifier) {
    var visibleText by remember { mutableStateOf("") }

    LaunchedEffect(text) {
        text.forEachIndexed { index, _ ->
            delay(5)
            visibleText = text.substring(0, index + 1)
        }
    }
    Text(
        text = visibleText,
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_small))
    )
}

@Composable
fun AbilityIcon(ability: Ability, onClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onClick(ability.descriptionRes) }),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(id = R.dimen.card_elevation)),
        border = BorderStroke(3.dp, MaterialTheme.colorScheme.outline),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.inverseSurface)
    ) {
        AsyncImage(
            model = ability.imageRes,
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(R.dimen.ability_size))
                .padding(dimensionResource(R.dimen.padding_small))
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Light() {
    LolChampionsTheme {
        ChampionApp()
    }
}

@Preview(showBackground = true)
@Composable
fun Dark() {
    LolChampionsTheme(darkTheme = true) {
        ChampionApp()
    }
}