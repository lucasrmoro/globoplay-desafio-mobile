package br.com.globoplay.presentation.streams.list.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.globoplay.presentation.streams.list.presentation.widgets.GenreWithStreamsCarousel
import br.com.globoplay.presentation.widgets.CommonAppScreen
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListStreamsScreen(
    viewModel: ListStreamsViewModel = koinViewModel(),
    navController: NavController,
    onNavigateToStreamDetails: (Int) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val scrollBehavior =
        TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val scrollState = rememberScrollState()

    LaunchedEffect(key1 = Unit) {
        viewModel.getGenreWithStreams()
    }

    CommonAppScreen(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        isScreenLoading = uiState.isLoading
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
        ) {
            uiState.genreWithStreams.forEach {
                GenreWithStreamsCarousel(
                    content = it,
                    onNavigateToStreamDetails = onNavigateToStreamDetails,
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
@Preview
fun ListStreamsScreenPreview() {
    ListStreamsScreen(navController = rememberNavController(), onNavigateToStreamDetails = {})
}