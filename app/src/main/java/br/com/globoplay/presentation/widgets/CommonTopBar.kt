package br.com.globoplay.presentation.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun CommonTopAppBar(
    title: String,
    onBackAction: (() -> Unit)?
) {
    if (onBackAction != null) {
        TopAppBarWithBackButton(title = title, onBackButtonClicked = onBackAction)
    } else {
        TopAppBarWithNoBackButton(title = title)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBarWithBackButton(title: String, onBackButtonClicked: () -> Unit) {
    TopAppBar(
        title = { TopAppBarTitle(title = title) },
        navigationIcon = { TopAppBarBackButton(onBackButtonClicked) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBarWithNoBackButton(title: String) {
    TopAppBar(
        title = { TopAppBarTitle(title = title) }
    )
}

@Composable
private fun TopAppBarTitle(title: String) {
    Row(horizontalArrangement = Arrangement.Start) {
        Text(text = title)
    }
}

@Composable
private fun TopAppBarBackButton(onBackButtonClicked: () -> Unit) {
    IconButton(onClick = onBackButtonClicked) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = ""
        )
    }
}