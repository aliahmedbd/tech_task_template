package com.aliahmed.techtasktemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aliahmed.techtasktemplate.presentation.navigation.NavGraph
import com.aliahmed.techtasktemplate.ui.theme.TechtasktemplateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TechtasktemplateTheme {
                NavGraph()
            }
        }
    }
}