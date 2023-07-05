package com.anggitwr.springkotlin.service

import org.springframework.http.HttpStatus

class EmployeNotFoundException(val statusCode: HttpStatus, val reason: String) : Exception() {

}
