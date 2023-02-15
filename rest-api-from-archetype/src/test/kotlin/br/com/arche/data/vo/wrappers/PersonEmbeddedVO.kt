package br.com.arche.data.vo.wrappers

import br.com.arche.data.vo.v1.PersonVO
import com.fasterxml.jackson.annotation.JsonProperty

class PersonEmbeddedVO {

    @JsonProperty("personVOList")
    var persons: List<PersonVO>? = null
}