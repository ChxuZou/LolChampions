package com.example.lolchampions

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lolchampions.ui.theme.LolChampionsTheme
import data.ChampionsRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LolChampionsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChampionApp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChampionApp() {
    Scaffold(
        containerColor = Color(0xFF040C14),
        topBar = {
            ChampionTopAppBar()
        }
    ) { innerPadding ->
        ChampionList(ChampionsRepository.champions, Modifier.padding(innerPadding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChampionTopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.icon_size))
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                    painter = painterResource(R.drawable.lol_icon),

                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }

        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = colorResource(id = R.color.ocean_blue)),
        modifier = Modifier.height(80.dp).border(BorderStroke(3.dp, MaterialTheme.colorScheme.outline))
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LolChampionsTheme {
        ChampionApp()
    }
}