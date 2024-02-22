package com.iamkamrul.example

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.neverEqualPolicy
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamkamrul.example.validator.EmailInput
import com.iamkamrul.example.validator.PasswordInput
import com.iamkamrul.formz.FormZ
import com.iamkamrul.formz.FormzSubmissionStatus
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel : ViewModel(){
    private val _formZSubmissionStatus = MutableStateFlow<FormzSubmissionStatus<String,Exception>>(FormzSubmissionStatus.Initial)
    val formZSubmissionStatus get() = _formZSubmissionStatus.asStateFlow()

    var emailInput by mutableStateOf(EmailInput(), neverEqualPolicy())
        private set

    var passwordInput by mutableStateOf(PasswordInput(), neverEqualPolicy())
        private set

    var isFormValid by mutableStateOf(false)
        private set

    fun onChangeEmailInput(value:String){
        emailInput  = emailInput
        emailInput.dirty(value)
        checkFormIsValid()
    }

    fun onChangePasswordInput(value:String){
        passwordInput  = passwordInput
        passwordInput.dirty(value)
        checkFormIsValid()
    }

    private fun checkFormIsValid(){
        isFormValid = FormZ.validate(listOf(emailInput,passwordInput))
    }

    fun loginUser(){
        viewModelScope.launch {
            _formZSubmissionStatus.value = FormzSubmissionStatus.InProgress
            delay(2000)
            _formZSubmissionStatus.value = FormzSubmissionStatus.Success("Success: ${emailInput.value}")
        }
    }
}