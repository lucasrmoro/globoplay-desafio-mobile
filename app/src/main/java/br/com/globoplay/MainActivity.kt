package br.com.globoplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.globoplay.presentation.MainScreen
import br.com.globoplay.presentation.theme.GloboPlayTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GloboPlayTheme {
                MainScreen()
            }
        }
    }

}