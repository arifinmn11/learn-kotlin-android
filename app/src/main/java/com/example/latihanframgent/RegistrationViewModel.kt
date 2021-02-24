package com.example.latihanframgent

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RegistrationViewModel : ViewModel() {
    private var _isNameValid = MutableLiveData<ResourceState>()

    val isNameValid: MutableLiveData<ResourceState>
        get() {
            return _isNameValid
        }

    fun inputNameValidation(name: String) {
        //Simulasi delay dari backend API
        GlobalScope.launch {
            _isNameValid.postValue(ResourceState.loading())
            delay(3000)
            if (!name.isNullOrBlank()) {
                _isNameValid.postValue(ResourceState.success(true))
            } else {
                _isNameValid.postValue(ResourceState.fail("Input can not empty"))
            }
        }
    }
}