package br.com.globoplay.presentation.streams.list.presentation.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import br.com.globoplay.core.providers.DimensProvider
import br.com.globoplay.presentation.streams.list.domain.model.Stream
import coil.compose.AsyncImage

@Composable
fun StreamCard(
    content: Stream,
    onNavigateDetailList: (Int) -> Unit = {},
) {
    Card(
        shape = RoundedCornerShape(DimensProvider.TINY_DIMEN),
        modifier = Modifier
            .size(
                width = DimensProvider.HUGE_DIMEN,
                height = DimensProvider.HUGEST_DIMEN
            )
            .padding(
                horizontal = DimensProvider.TINIEST_DIMEN
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
