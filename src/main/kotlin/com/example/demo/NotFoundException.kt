package com.example.demo

import org.springframework.http.HttpStatus

class NotFoundException(val statusCode: HttpStatus, val reason: String) : Exception()