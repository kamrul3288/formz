package com.iamkamrul.formz

sealed interface FormzSubmissionStatus<out D,out E>{
    data object Initial:FormzSubmissionStatus<Nothing,Nothing>
    data object InProgress:FormzSubmissionStatus<Nothing,Nothing>
    data class Failure<E>(val error:E):FormzSubmissionStatus<Nothing,E>
    data  class Success<D>(val data:D):FormzSubmissionStatus<D,Nothing>
}
