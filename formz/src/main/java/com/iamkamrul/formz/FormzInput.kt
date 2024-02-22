package com.iamkamrul.formz

abstract class FormzInput<T:Any,E> {

    var value:T = pure()
    var isPure = true
        private set

    abstract fun pure():T

    open fun dirty(value:T):FormzInput<T,E>{
        this.value = value
        isPure = false
        return this
    }


    abstract fun validator(value: T): E?

    fun isValid():Boolean{
        return validator(value) == null
    }

    fun isError():Boolean{
        return if (isPure) false else validator(value) != null
    }

    fun displayError():E?{
        return if (isPure) null else validator(value)
    }
}