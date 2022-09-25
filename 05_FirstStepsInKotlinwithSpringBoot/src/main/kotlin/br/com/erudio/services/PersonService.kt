package br.com.erudio.services

import br.com.erudio.data.vo.v1.PersonVO
import br.com.erudio.exceptions.ResourceNotFoundException
import br.com.erudio.mapper.DozerMapper
import br.com.erudio.mapper.PersonMapper
import br.com.erudio.model.Person
import br.com.erudio.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import br.com.erudio.data.vo.v2.PersonVO as PersonV2

import org.springframework.stereotype.Service

import java.util.logging.Logger

@Service
class PersonService {
    @Autowired
    private lateinit var repository: PersonRepository

    @Autowired
    private lateinit var mapper: PersonMapper
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun finById(id: Long): PersonVO {
        logger.info("Procurando uma pessoa")



        var person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found this ID!") }
        return DozerMapper.parseObject(person, PersonVO::class.java)

    }

    fun findAll(): List<PersonVO> {
        logger.info("Achando a Lista de pessoas")


      val persons =  repository.findAll()
        return DozerMapper.parseListObjects(persons, PersonVO::class.java)
    }


    fun create(person: PersonVO): PersonVO {
        logger.info("criando uma pessoa com o nome ${person.firstName}!")
        var entity: Person = DozerMapper.parseObject(person, Person::class.java)
        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }
    fun createV2(person: PersonV2): PersonV2 {
        logger.info("criando uma pessoa com o nome ${person.firstName}!")
        var entity: Person = mapper.mapVOToEntity(person)
        return mapper.mapEntityToVO(repository.save(entity))
    }

    fun update(person: PersonVO) : PersonVO {
        logger.info("atualizando uma pessoa com o id ${person.id}!")
        val entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundException("No records found this ID!") }
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
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