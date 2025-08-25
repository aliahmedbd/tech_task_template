package com.aliahmed.techtasktemplate.presentation.screens

sealed interface HomeIntent {
    data object Loading : HomeIntent
}