package br.com.erudio.controller



import br.com.erudio.data.vo.v1.PersonVO
import br.com.erudio.data.vo.v2.PersonVO as PersonV2
import br.com.erudio.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/person/v1")
class PersonController {


    @Autowired
    private lateinit var service: PersonService

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE])
    fun findAll():List<PersonVO> {

// if call Get without id, fall in method findAll
        return service.findAll()

    }
    @GetMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE])
    fun findById(@PathVariable(value = "id")id: Long,
    ): PersonVO {

        return service.finById(id)
    }
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE],
    produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody person: PersonVO): PersonVO {

        return service.create(person)
    }
@PostMapping(value = ["/2"], consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE],
    produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createV2(@RequestBody person: PersonV2): PersonV2 {

        return service.createV2(person)
    }
    @PutMapping(consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE],
    produces = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody person: PersonVO): PersonVO {

        return service.update(person)
    }
    @DeleteMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE])
    fun delete(@PathVariable(value = "id")id: Long) : ResponseEntity<*>{
       service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }


}

