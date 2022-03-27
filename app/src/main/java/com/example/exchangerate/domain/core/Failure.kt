package com.example.exchangerate.domain.core

sealed class Failure{
    object NetworkConnectionError: Failure()
    object ServerError : Failure()
}
