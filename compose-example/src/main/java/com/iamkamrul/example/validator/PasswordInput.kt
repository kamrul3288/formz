package com.iamkamrul.example.validator

import com.iamkamrul.formz.FormzInput

class PasswordInput : FormzInput<String,String>(){
    override fun pure(): String  = ""

    override fun validator(value: String): String? {
       return if (value.length<6){
           "Password must be at least 6 characters long."
       }else{
           null
       }
    }
}