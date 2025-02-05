package com.example.dev2dev.ui.presentation.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dev2dev.data.api.dtoUser.ApiTokenDto
import com.example.dev2dev.data.api.dtoUser.AuthUserDto
import com.example.dev2dev.data.jwtToken.ILocalTokenRepository
import com.example.dev2dev.domain.interactor.auth.IAuthInteractor
import com.example.dev2dev.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authInteractor: IAuthInteractor,
    private val localTokenRepository: ILocalTokenRepository,
) : ViewModel() {

    private val _loginResult = MutableLiveData<NetworkResult<ApiTokenDto>>()
    val loginResult: LiveData<NetworkResult<ApiTokenDto>> get() = _loginResult

    private val _singUpResult = MutableLiveData<NetworkResult<Unit>>()
    val singUpResult: LiveData<NetworkResult<Unit>> get() = _singUpResult

    // StateFlow для токенов
    private val _refreshToken = MutableStateFlow("")
    val refreshToken: StateFlow<String> get() = _refreshToken

    private val _accessToken = MutableStateFlow("")
    val accessToken: StateFlow<String> get() = _accessToken

    fun singUp(email: String, password: String) {
        viewModelScope.launch {
            _singUpResult.value = NetworkResult.Loading()
            _singUpResult.value = authInteractor.singUp(AuthUserDto(email = email, password = password))

        }
    }

    fun logIn(email: String, password: String) {
        viewModelScope.launch {
            _loginResult.value = NetworkResult.Loading()
            _loginResult.value = authInteractor.logIn(AuthUserDto(email = email, password = password))
        }
    }

    // Метод для обновления токенов
    fun updateTokens() {
        _refreshToken.value = localTokenRepository.getRefreshToken()
        _accessToken.value = localTokenRepository.getAccessToken()

    }

}