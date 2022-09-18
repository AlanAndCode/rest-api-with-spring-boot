package br.com.erudio.services

import br.com.erudio.model.Person

import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun finById(id: Long): Person {
        logger.info("Procurando uma pessoa")

        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Leandro"
        person.lastName = "Costa"
        person.address = "Uberlandia - Minas Gerais - Brasil"
        person.gender = "Male"
        return person

    }

    fun findAll(): List<Person> {
        logger.info("Achando a Lista de pessoas")

        val persons: MutableList<Person> = ArrayList()
        for (i in 0..7) {
            val person = mockPerson(i)
            persons.add(person)
        }
        return persons
    }
    private fun mockPerson(i: Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Person name $i"
        person.lastName = "Last name $i"
        person.address = "Some Addresss in Brasil"
        person.gender = "Male"
        return person

    }
}