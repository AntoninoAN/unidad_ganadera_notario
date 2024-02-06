package com.example.model.exceptions

abstract class SchoolExceptions(private val myMessage: String) : Exception(myMessage)

class SchoolRemoteExceptions(private val exception: Exception): SchoolExceptions(exception.message ?: "N/A")
class SchoolLocalExceptions(private val exception: Exception): SchoolExceptions(exception.message ?: "N/A")