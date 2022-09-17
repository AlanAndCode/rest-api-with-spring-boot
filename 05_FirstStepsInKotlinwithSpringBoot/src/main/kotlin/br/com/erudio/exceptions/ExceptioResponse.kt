package br.com.erudio.exceptions

import java.util.Date

class ExceptioResponse (
    val timestamp: Date,
            val message: String?,
                    val details : String
)