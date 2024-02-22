package com.iamkamrul.formz

object FormZ {
    fun validate(inputs:List<FormzInput<*,*>>):Boolean{
        return inputs.all {
            it.isValid()
        }
    }

    fun isPure(inputs:List<FormzInput<*,*>>):Boolean{
        return inputs.all {
            it.isPure
        }
    }
}