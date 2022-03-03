package com.example.demo

import org.springframework.http.HttpStatus

class GameNotFoundException(val statusCode: HttpStatus, val reason: String) : Exception()