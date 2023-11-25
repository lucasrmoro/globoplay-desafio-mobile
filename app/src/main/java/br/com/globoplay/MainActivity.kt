package br.com.globoplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import br.com.globoplay.presentation.navigation.NavigationGraph
import br.com.globoplay.presentation.theme.GloboPlayTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GloboPlayTheme {
                NavigationGraph(navController = rememberNavController())
            }
        }
    }

}