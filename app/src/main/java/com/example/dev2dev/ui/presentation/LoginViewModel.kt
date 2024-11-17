package com.example.dev2dev.ui.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dev2dev.data.api.dtoUser.User
import com.example.dev2dev.domain.usecases.SingInUseCase
import com.example.dev2dev.domain.usecases.SingUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val singUpUseCase: SingUpUseCase,
    private val singInUseCases: SingInUseCase,
):ViewModel() {

       // private val _singUp = MutableLiveData<NetworkResult<ApiToken>>()  а зачем ?

    init {

    }

    fun singUp(){
        viewModelScope.launch {
            singUpUseCase.invoke(User(email = "", password = ""))
        }
    }

    fun singIn(){
        viewModelScope.launch {
            singInUseCases.invoke(User(email = "", password = ""))
        }
    }

}