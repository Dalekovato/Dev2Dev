package com.example.dev2dev.ui.presentation.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dev2dev.data.api.dtoUser.ApiToken
import com.example.dev2dev.data.api.dtoUser.AuthUser
import com.example.dev2dev.data.jwtToken.ILocalTokenRepository
import com.example.dev2dev.domain.interactor.IAuthRepository
import com.example.dev2dev.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authInteractor: IAuthRepository,
    private val localTokenRepository: ILocalTokenRepository
):ViewModel() {


    private val _loginResult = MutableLiveData<NetworkResult<ApiToken>>()
    val loginResult: LiveData<NetworkResult<ApiToken>> get() = _loginResult

    // StateFlow для токенов
    private val _refreshToken = MutableStateFlow("")
    val refreshToken: StateFlow<String> get() = _refreshToken

    private val _accessToken = MutableStateFlow("")
    val accessToken: StateFlow<String> get() = _accessToken

    fun singUp(email: String, password: String) {

        viewModelScope.launch {
            _loginResult.value = NetworkResult.Loading()
            _loginResult.value = authInteractor.singUp(AuthUser(email = email, password = password))

        }
    }

    fun logIn(email: String, password: String){
        viewModelScope.launch {
            _loginResult.value = NetworkResult.Loading()
            _loginResult.value = authInteractor.logIn(AuthUser(email = email, password = password)).also {

            }


        }


    }


    // Метод для обновления токенов
    fun updateTokens() {
        _refreshToken.value = localTokenRepository.getRefreshToken()
        _accessToken.value = localTokenRepository.getAccessToken()

    }




}