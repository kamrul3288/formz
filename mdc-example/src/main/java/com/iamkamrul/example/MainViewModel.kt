package com.iamkamrul.example

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamkamrul.formz.FormzSubmissionStatus
import com.iamkamrul.formz.FormzSubmissionStatus2
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){
    private val _formZSubmissionStatus = MutableStateFlow<FormzSubmissionStatus2<String,Exception>>(FormzSubmissionStatus2.InProgress(false))
    val formZSubmissionStatus get() = _formZSubmissionStatus.asStateFlow()

    fun loginUser(email:String,password:String){
        viewModelScope.launch {
            _formZSubmissionStatus.value = FormzSubmissionStatus2.InProgress(true)
            delay(2000)
            _formZSubmissionStatus.value = FormzSubmissionStatus2.InProgress(false)
            delay(100)
            _formZSubmissionStatus.value = FormzSubmissionStatus2.Success("Success: $email")
        }
    }
}