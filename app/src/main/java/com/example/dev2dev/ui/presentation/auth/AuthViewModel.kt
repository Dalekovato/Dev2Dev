package com.example.dev2dev.ui.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dev2dev.data.api.dtoUser.ApiToken
import com.example.dev2dev.data.api.dtoUser.AuthUser
import com.example.dev2dev.domain.interactor.AuthInteractorImpl
import com.example.dev2dev.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authInteractorImpl: AuthInteractorImpl,
):ViewModel() {



    fun singUp(email: String, password: String){

        viewModelScope.launch {
            authInteractorImpl.singUn(AuthUser(email = email, password = password))
        }

    }

    fun singIn(email: String , password: String){
        viewModelScope.launch {
            authInteractorImpl.singIn(AuthUser(email = email, password = password))
        }
    }

    fun saveToken(token: ApiToken){
        viewModelScope.launch {
            authInteractorImpl.saveToken(token)
        }
    }

    fun getAccessToken():String{
        val accessToken = viewModelScope.launch {
             authInteractorImpl.getAccessToken()
        }
        return accessToken.toString()
    }

     fun getRefreshToken():String{
         val refreshToken = viewModelScope.launch {
             authInteractorImpl.getRefreshToken()
         }
         return refreshToken.toString()

    }

    fun clearToken(){
        viewModelScope.launch {
        authInteractorImpl.clearToken()
        }
    }

}