package com.example.dev2dev.ui.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dev2dev.data.api.dtoUser.AuthUser
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



    fun singUp(email: String, password: String){
        viewModelScope.launch {
            singUpUseCase.invoke(AuthUser(email = email, password = password))
        }
    }

    fun singIn(email: String , password: String){
        viewModelScope.launch {
            singInUseCases.invoke(AuthUser(email = email, password = password))
        }
    }


}