package br.com.arche.data.vo.wrappers

import br.com.arche.data.vo.v1.BookVO
import com.fasterxml.jackson.annotation.JsonProperty

class BookEmbeddedVO {

    @JsonProperty("bookVOList")
    var books: List<BookVO>? = null
}