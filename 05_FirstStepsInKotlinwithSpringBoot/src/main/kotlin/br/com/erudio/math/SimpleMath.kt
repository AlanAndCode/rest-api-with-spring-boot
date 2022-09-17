package br.com.erudio.math

import br.com.erudio.converters.NumberConverter
import br.com.erudio.exceptions.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable

class SimpleMath {
    fun sum(numberOne: Double, numberTwo: Double) = numberOne + numberTwo
    fun sub(numberOne: Double, numberTwo: Double) = numberOne - numberTwo
    fun mult(numberOne: Double, numberTwo: Double) = numberOne * numberTwo
    fun div(numberOne: Double, numberTwo: Double) = numberOne / numberTwo
    fun med(numberOne: Double, numberTwo: Double) = (numberOne + numberTwo) / 2
    fun raiz(number: Double) = Math.sqrt(number)
}