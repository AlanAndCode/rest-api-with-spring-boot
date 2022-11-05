package br.com.erudio.exceptions.handler

import br.com.erudio.exceptions.ExceptioResponse
import br.com.erudio.exceptions.RequiredObjectisNullException
import br.com.erudio.exceptions.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception
import java.util.*

@ControllerAdvice
@RestController
class CustomizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {
@ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest):
        ResponseEntity<ExceptioResponse> {
        val exceptioResponse = ExceptioResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity<ExceptioResponse>(exceptioResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }
    @ExceptionHandler(RequiredObjectisNullException::class)
    fun handleBadRequestExceptions(ex: Exception, request: WebRequest):
            ResponseEntity<ExceptioResponse> {
        val exceptioResponse = ExceptioResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity<ExceptioResponse>(exceptioResponse, HttpStatus.BAD_REQUEST)
    }

}