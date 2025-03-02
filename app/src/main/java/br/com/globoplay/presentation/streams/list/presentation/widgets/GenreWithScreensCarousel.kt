package br.com.globoplay.presentation.streams.list.presentation.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.globoplay.presentation.streams.list.domain.model.GenreWithStreams

@Composable
fun GenreWithStreamsCarousel(
    content: GenreWithStreams,
    modifier: Modifier = Modifier,
    onNavigateToStreamDetails: (Int) -> Unit = {},
) {
    val lazyListState = rememberLazyListState()

    Column(modifier = modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = content.genre.name,
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )

        Spacer(modifier = Modifier.size(8.dp))

        LazyRow(
            state = lazyListState,
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
        ) {
            items(items = content.streams) {
                StreamCard(
                    content = it,
                    onNavigateToStreamDetails
                )
            }
        }
    }
}