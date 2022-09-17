package br.com.erudio.controller

import br.com.erudio.converters.NumberConverter
import br.com.erudio.converters.NumberConverter.convertToDouble
import br.com.erudio.exceptions.UnsupportedMathOperationException
import br.com.erudio.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class MathController {

    val counter: AtomicLong = AtomicLong()

    private val math: SimpleMath = SimpleMath()

@RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value = "numberOne")numberOne: String?,
            @PathVariable(value = "numberTwo")numberTwo: String?
): Double {
    if(!NumberConverter.isNumeric(numberOne)  || !NumberConverter.isNumeric(numberTwo))
        throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }



    @RequestMapping(value = ["/mult/{numberOne}/{numberTwo}"])
    fun mult(@PathVariable(value = "numberOne")numberOne: String?,
            @PathVariable(value = "numberTwo")numberTwo: String?
    ): Double {
        if(!NumberConverter.isNumeric(numberOne)  || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun sub(@PathVariable(value = "numberOne")numberOne: String?,
             @PathVariable(value = "numberTwo")numberTwo: String?
    ): Double {
        if(!NumberConverter.isNumeric(numberOne)  || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/div/{numberOne}/{numberTwo}"])
    fun div(@PathVariable(value = "numberOne")numberOne: String?,
            @PathVariable(value = "numberTwo")numberTwo: String?
    ): Double {
        if(!NumberConverter.isNumeric(numberOne)  || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/med/{numberOne}/{numberTwo}"])
    fun med(@PathVariable(value = "numberOne")numberOne: String?,
            @PathVariable(value = "numberTwo")numberTwo: String?
    ): Double {
        if(!NumberConverter.isNumeric(numberOne)  || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.med(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/raiz/{number}"])
    fun raiz(@PathVariable(value = "number")numberOne: String?,

    ): Double {
        if(!NumberConverter.isNumeric(numberOne))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.raiz(NumberConverter.convertToDouble(numberOne))
    }
}
