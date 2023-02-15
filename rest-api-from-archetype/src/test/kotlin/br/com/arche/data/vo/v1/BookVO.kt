package br.com.arche.data.vo.v1

import jakarta.xml.bind.annotation.XmlRootElement
import java.util.*

@XmlRootElement
data class BookVO (

    var id: Long = 0,
    var author: String = "",
    var launchDate: Date? = null,
    var price: Double = 0.0,
    var title: String = ""
)