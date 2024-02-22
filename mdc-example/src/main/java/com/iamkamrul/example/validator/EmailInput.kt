package com.iamkamrul.example.validator

import com.iamkamrul.formz.FormzInput

class EmailInput : FormzInput<String,String>(){
    override fun pure(): String = ""

    private val emailRegex = Regex("^[a-zA-Z\\d.!#\$%&’*+/=?^_`{|}~-]+@[a-zA-Z\\d-]+(?:\\.[a-zA-Z\\d-]+)*\$")

    override fun validator(value: String): String? {
        return when(emailRegex.matches(value)){
            true -> null
            false -> "Please enter valid email"
        }
    }
}