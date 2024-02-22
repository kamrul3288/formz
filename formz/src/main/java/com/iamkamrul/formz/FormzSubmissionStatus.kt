package com.iamkamrul.formz

sealed interface FormzSubmissionStatus<out D,out E>{
    data object Initial:FormzSubmissionStatus<Nothing,Nothing>
    data object InProgress:FormzSubmissionStatus<Nothing,Nothing>
    data class Failure<E>(val error:E):FormzSubmissionStatus<Nothing,E>
    data  class Success<D>(val data:D):FormzSubmissionStatus<D,Nothing>
}

sealed interface FormzSubmissionStatus2<out D,out E>{
    data class InProgress(val isProgress:Boolean):FormzSubmissionStatus2<Nothing,Nothing>
    data class Failure<E>(val error:E):FormzSubmissionStatus2<Nothing,E>
    data  class Success<D>(val data:D):FormzSubmissionStatus2<D,Nothing>
}
