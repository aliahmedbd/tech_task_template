package com.aliahmed.techtasktemplate.presentation.screens

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aliahmed.techtasktemplate.domain.model.UseCaseResult
import com.aliahmed.techtasktemplate.domain.usecase.AccountDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val accountDataUseCase: AccountDataUseCase
) : ViewModel(){

    private var _uiState = MutableStateFlow<HomeState?>(value = null)
    val uiState: MutableStateFlow<HomeState?> = _uiState

    fun sendIntent(homeIntent: HomeIntent) {
        when(homeIntent) {
            HomeIntent.Loading ->  {
                viewModelScope.launch {
                    _uiState.value = HomeState.Loading
                    val result = accountDataUseCase.getAccountData()
                    when(result) {
                        is UseCaseResult.Success -> _uiState.value = HomeState.Success(result.data)
                        else -> {
                            _uiState.value = HomeState.Error
                        }
                    }
                }
            }
        }
    }
}