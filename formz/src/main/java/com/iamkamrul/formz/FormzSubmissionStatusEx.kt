package com.iamkamrul.formz

fun<D,E> FormzSubmissionStatus<D,E>.isInitial():Boolean = this is FormzSubmissionStatus.Initial
fun<D,E> FormzSubmissionStatus<D,E>.isInProgress():Boolean = this is FormzSubmissionStatus.InProgress
fun<D,E> FormzSubmissionStatus<D,E>.isFailure():Boolean = this is FormzSubmissionStatus.Failure
fun<D,E> FormzSubmissionStatus<D,E>.isSuccess():Boolean = this is FormzSubmissionStatus.Success