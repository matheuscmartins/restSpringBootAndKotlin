package br.com.homeoffice.mapper.custom

import br.com.homeoffice.data.vo.v2.PersonVO
import br.com.homeoffice.model.Person
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonMapper {

    fun mapEntityToVO(person: Person): PersonVO {
        val vo = PersonVO()
        vo.id = person.id
        vo.address = person.address
        vo.birthDay = Date()
        vo.firstName = person.firstName
        vo.gender = person.gender
        vo.lastName = person.lastName
        return vo
    }

    fun mapVOToEntity(person: PersonVO): Person {
        val entity = Person()
        entity.id = person.id
        entity.address = person.address
        //entity.birthDay = Date()
        entity.firstName = person.firstName
        entity.gender = person.gender
        entity.lastName = person.lastName
        return entity
    }
}