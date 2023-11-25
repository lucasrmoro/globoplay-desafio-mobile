package br.com.globoplay.presentation.streams.list.presentation.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import br.com.globoplay.presentation.streams.list.domain.model.Stream
import coil.compose.AsyncImage

@Composable
fun StreamCard(
    content: Stream,
    onNavigateDetailList: (Int) -> Unit = {},
) {
    Card(
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier
            .size(
                width = 100.dp,
                height = 140.dp
            )
            .padding(
                horizontal = 4.dp
            )
            .clickable {
                onNavigateDetailList.invoke(content.id)
            }
    ) {
        AsyncImage(
            model = content.imageUrl,
            contentScale = ContentScale.FillBounds,
            contentDescription = content.title
        )
    }
}
