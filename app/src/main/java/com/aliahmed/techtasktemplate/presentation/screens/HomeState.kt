package com.aliahmed.techtasktemplate.presentation.screens

sealed interface HomeState {
    data object Loading : HomeState
    data class Success(val data: String) : HomeState
    data object Error : HomeState
}