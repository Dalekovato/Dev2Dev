package com.example.dev2dev.ui.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dev2dev.domain.interactor.Base.IBaseInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BaseViewModel @Inject constructor(
    private val baseInteractor: IBaseInteractor
) : ViewModel() {

    fun testRoad(){
        viewModelScope.launch {
            baseInteractor.testRoad()
        }
    }

}