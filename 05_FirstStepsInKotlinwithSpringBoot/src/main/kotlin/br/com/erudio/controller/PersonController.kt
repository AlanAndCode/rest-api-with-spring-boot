package br.com.erudio.controller



import br.com.erudio.data.vo.v1.PersonVO
import br.com.erudio.services.PersonService
import br.com.erudio.util.MediaType
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/person/v1")
@Tag(name = "People", description = "Endpoints for Managing People")
class PersonController {


    @Autowired
    private lateinit var service: PersonService

    @GetMapping(produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    @Operation(summary = "find all peoples", description = "finds all people",
    tags = ["People"],
        responses = [
            ApiResponse(
                description = "Sucess",
                responseCode = "200",
                content = [
                    Content(array = ArraySchema(schema = Schema(implementation = PersonVO::class)))
                ]
            ),
        ApiResponse(description = "No Content", responseCode = "204", content = [
            Content(schema = Schema(implementation = Unit::class))
        ]),
            ApiResponse(description = "Bad Request", responseCode = "400", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Unauthorized", responseCode = "401", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Not Found", responseCode = "404", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Internal Error", responseCode = "500", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
        ]
        )
    fun findAll():List<PersonVO> {

// if call Get without id, fall in method findAll
        return service.findAll()

    }
    @CrossOrigin(origins = ["http://localhost:8080"])
    @GetMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    @Operation(summary = "finds a person", description = "finds a person",
        tags = ["People"],
        responses = [
            ApiResponse(
                description = "Sucess",
                responseCode = "200",
                content = [
                    Content(schema = Schema(implementation = PersonVO::class))
                ]
            ),
            ApiResponse(description = "No Content", responseCode = "204", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Bad Request", responseCode = "400", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Unauthorized", responseCode = "401", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Not Found", responseCode = "404", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Internal Error", responseCode = "500", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
        ]
    )
    fun findById(@PathVariable(value = "id")id: Long,
    ): PersonVO {

        return service.finById(id)
    }
    @CrossOrigin(origins = ["http://localhost:8080", "https://erudio.com.br"])
    @PostMapping(consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML],
    produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    @Operation(summary = "Adds a person", description = "Adds  a person",
        tags = ["People"],
        responses = [
            ApiResponse(
                description = "Sucess",
                responseCode = "200",
                content = [
                    Content(schema = Schema(implementation = PersonVO::class))
                ]
            ),
            ApiResponse(description = "Bad Request", responseCode = "400", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Unauthorized", responseCode = "401", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Internal Error", responseCode = "500", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
        ]
    )
    fun create(@RequestBody person: PersonVO): PersonVO {

        return service.create(person)
    }

    @PutMapping(consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML],
    produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    @Operation(summary = "update a person information", description = "update a person information",
        tags = ["People"],
        responses = [
            ApiResponse(
                description = "Sucess",
                responseCode = "200",
                content = [
                    Content(schema = Schema(implementation = PersonVO::class))
                ]
            ),
            ApiResponse(description = "No Content", responseCode = "204", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Bad Request", responseCode = "400", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Unauthorized", responseCode = "401", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Not Found", responseCode = "404", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Internal Error", responseCode = "500", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
        ]
    )
        fun update(@RequestBody person: PersonVO): PersonVO {

        return service.update(person)
    }
    @DeleteMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    @Operation(summary = "delete a person", description = "delete a person",
        tags = ["People"],
        responses = [

            ApiResponse(description = "No Content", responseCode = "204", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Bad Request", responseCode = "400", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Unauthorized", responseCode = "401", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Not Found", responseCode = "404", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Internal Error", responseCode = "500", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
        ]
    )
    fun delete(@PathVariable(value = "id")id: Long) : ResponseEntity<*>{
       service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }


}

