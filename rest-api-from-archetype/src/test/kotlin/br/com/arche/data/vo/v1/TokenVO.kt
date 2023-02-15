package br.com.arche.data.vo.v1

import jakarta.xml.bind.annotation.XmlRootElement
import java.util.*

@XmlRootElement
data class TokenVO(

    var username: String? = null,
    var authenticated: Boolean? = null,
    var created: Date? = null,
    var expiration: Date? = null,
    var accessToken: String? = null,
    var refreshToken: String? = null,
)