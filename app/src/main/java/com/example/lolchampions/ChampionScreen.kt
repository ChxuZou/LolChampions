package com.example.lolchampions

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lolchampions.ui.theme.LolChampionsTheme
import model.Champion

@Composable
fun ChampionList(championList: List<Champion>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
        modifier = modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_small))
    ) {
        items(championList) { champion ->
            ChampionItem(champion)
        }
    }
}

@Composable
fun ChampionItem(
    champion: Champion,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(id = R.dimen.card_elevation)),
        border = BorderStroke(3.dp, MaterialTheme.colorScheme.outline),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.ocean_blue))

    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                ChampionIcon(champion.imageRes)
                Spacer(Modifier.weight(1f))
                ChampionInformation(champion.nameRes, champion.regionRes)
                Spacer(Modifier.weight(1f))
                ChampionItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded },
                )
            }
            if (expanded) {
                ChampionHabilities(
                    champion, modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}

@Composable
fun ChampionHabilities(champion: Champion, modifier: Modifier) {
    //TODO
    Text(text = "Habilidades")
}

@Composable
fun ChampionItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun ChampionInformation(
    nameRes: Int,
    regionRes: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(nameRes),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_small))

            )
        Text(
            text = stringResource(regionRes),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_small))
        )


    }
}

@Composable
fun ChampionIcon(
    imageRes: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.medium),
        contentScale = ContentScale.Crop,
        painter = painterResource(imageRes),
        contentDescription = null
    )
}


@Preview
@Composable
fun WoofPreview() {
    LolChampionsTheme {
        ChampionApp()
    }
}

