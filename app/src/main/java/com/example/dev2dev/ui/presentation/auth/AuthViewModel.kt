package com.example.dev2dev.ui.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import com.example.dev2dev.data.Jwt.LocalTokenRepository
import com.example.dev2dev.data.api.dtoUser.ApiToken
import com.example.dev2dev.data.api.dtoUser.AuthUser
import com.example.dev2dev.domain.interactor.IAuthRepository
import com.example.dev2dev.ui.presentation.HomeScreen
import com.example.dev2dev.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authInteractor: IAuthRepository,
    private val localTokenRepository: LocalTokenRepository
):ViewModel() {


//Тут забацать состояние

    fun singUp(email: String, password: String){

        viewModelScope.launch {
            val result = authInteractor.singUn(AuthUser(email = email, password = password))
// Тут его обработать

//            when(result){
//                is NetworkResult.Success -> {
//
//                }
//                is NetworkResult.Error->{
//
//                }
//                is NetworkResult.Loading->{
//
//                }
//            }
        }

    }

    fun singIn(email: String , password: String){
        viewModelScope.launch {
            authInteractor.singIn(AuthUser(email = email, password = password))
        }
    }


    fun getRefreshToken() = localTokenRepository.getRefreshToken()

    fun getAccessToken() = localTokenRepository.getAccessToken()


}