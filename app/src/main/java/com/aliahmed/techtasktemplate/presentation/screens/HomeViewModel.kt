package com.aliahmed.techtasktemplate.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel(){

    private var _uiState = MutableStateFlow<HomeState?>(value = null)
    val uiState: MutableStateFlow<HomeState?> = _uiState

    fun sendIntent(homeIntent: HomeIntent) {
        when(homeIntent) {
            HomeIntent.Loading ->  {
                viewModelScope.launch {
                    _uiState.value = HomeState.Loading
                    // TODO Complete it on the test day
                }
            }
        }
    }
}