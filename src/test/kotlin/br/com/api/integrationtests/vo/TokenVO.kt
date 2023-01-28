package br.com.api.integrationtests.vo

import java.util.*
import jakarta.xml.bind.annotation.XmlRootElement

@XmlRootElement
data class TokenVO(

    var username: String? = null,
    var authenticated: Boolean? = null,
    var created: Date? = null,
    var expiration: Date? = null,
    var accessToken: String? = null,
    var refreshToken: String? = null,
)