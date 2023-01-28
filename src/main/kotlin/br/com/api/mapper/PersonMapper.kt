package br.com.api.mapper

import br.com.api.data.vo.v1.PersonVO
import br.com.api.model.Person
import org.springframework.stereotype.Service

@Service
class PersonMapper {

    fun mapEntityToVO(person: Person): PersonVO {
        val vo = PersonVO()
        vo.key = person.id
        vo.address = person.address
        //vo.birthDay = Date()
        vo.firstName = person.firstName
        vo.lastName =person.lastName
        vo.gender = person.gender

  return vo
    }
//
    fun mapVOToEntity(person: PersonVO): Person {
        val entity = Person()
        entity.id = person.key
        entity.address = person.address
        //entity.birthDay = Date()
        entity.firstName = person.firstName
        entity.lastName =person.lastName
        entity.gender = person.gender

        return entity
    }
}