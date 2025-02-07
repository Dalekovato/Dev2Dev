package com.example.dev2dev.ui.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dev2dev.domain.interactor.main.IMainInteractor
import com.example.dev2dev.domain.interactor.main.MainInteractorImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainInteractorImpl: IMainInteractor
) : ViewModel() {

    fun testRoad(){
        viewModelScope.launch {
            mainInteractorImpl.testRoad()
        }
    }

}