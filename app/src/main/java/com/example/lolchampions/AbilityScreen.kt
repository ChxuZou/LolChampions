package com.example.lolchampions

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import model.Ability
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lolchampions.ui.theme.LolChampionsTheme

@Composable
fun AbilityList(championAbilities: List<Ability>, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
    ) {
        LazyRow(modifier = modifier) {
            items(championAbilities) { ability ->
                AbilityItem(ability = ability)
                Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)))
            }
        }

    }

}

@Composable
fun AbilityItem(ability: Ability) {
    var expanded by remember { mutableStateOf(false) }
    Column {
        AbilityIcon(ability.imageRes) { expanded = !expanded }
    }
    if (expanded) {
        AbilityInformation(ability.descriptionRes) { expanded = !expanded }
    }
}

@Composable
fun AbilityIcon(imageRes: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(id = R.dimen.card_elevation)),
        border = BorderStroke(3.dp, MaterialTheme.colorScheme.outline),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.inverseSurface)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(R.dimen.ability_size))
                .padding(dimensionResource(R.dimen.padding_small))
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun AbilityInformation(descriptionRes: Int, function: () -> Unit) {
    AlertDialog(
        onDismissRequest = function,
        confirmButton = {
            Text(
                text = "Aceptar",
                modifier = Modifier.clickable(onClick = function)
            )
        },
        text = {
            Text(
                text = stringResource(id = descriptionRes),
                modifier = Modifier
            )
        })


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