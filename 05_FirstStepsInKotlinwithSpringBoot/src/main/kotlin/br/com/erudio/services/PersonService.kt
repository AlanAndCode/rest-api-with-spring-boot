package br.com.erudio.services

import br.com.erudio.exceptions.ResourceNotFoundException
import br.com.erudio.model.Person
import br.com.erudio.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {
    @Autowired
    private lateinit var repository: PersonRepository
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun finById(id: Long): Person {
        logger.info("Procurando uma pessoa")



        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found this ID!") }

    }

    fun findAll(): List<Person> {
        logger.info("Achando a Lista de pessoas")


        return repository.findAll()
    }

    fun create(person: Person): Person {
        logger.info("criando uma pessoa com o nome ${person.firstName}!")
        return repository.save(person)
    }

    fun update(person: Person) {
        logger.info("atualizando uma pessoa com o id ${person.id}!")
        val entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundException("No records found this ID!") }
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
    }

    fun delete(id: Long) {
        logger.info("deletando uma pessoa com o id ${id}!")
        val entity = repository.findById(id)
            .orElseThrow {
                ResourceNotFoundException("No records found this ID!")
            }
        repository.delete(entity)
    }

}