package com.iamkamrul.formz

fun<D,E> FormzSubmissionStatus<D,E>.isInitial():Boolean = this is FormzSubmissionStatus.Initial
fun<D,E> FormzSubmissionStatus<D,E>.isInProgress():Boolean = this is FormzSubmissionStatus.InProgress
fun<D,E> FormzSubmissionStatus<D,E>.isFailure():Boolean = this is FormzSubmissionStatus.Failure
fun<D,E> FormzSubmissionStatus<D,E>.isSuccess():Boolean = this is FormzSubmissionStatus.Success


fun<D,E> FormzSubmissionStatus2<D,E>.isInProgress():Boolean = this is FormzSubmissionStatus2.InProgress
fun<D,E> FormzSubmissionStatus2<D,E>.isFailure():Boolean = this is FormzSubmissionStatus2.Failure
fun<D,E> FormzSubmissionStatus2<D,E>.isSuccess():Boolean = this is FormzSubmissionStatus2.Success