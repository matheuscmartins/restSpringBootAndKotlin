package br.com.homeoffice.services

import br.com.homeoffice.exceptions.ResourceNotFoundException
import br.com.homeoffice.model.Person
import br.com.homeoffice.repositories.PersonRepository
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.stereotype.Service

import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)
    fun findAll(): List<Person> {
        logger.info("Finding all people!")
        return repository.findAll()
    }

    fun findById(id: Long): Person {
        logger.info("Finding one person!")
        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("Object Not Found") }
    }


    fun create(person: Person): Person {
        logger.info("Creating one person with name ${person.firstName} !")
        return repository.save(person)
    }

    fun update(person: Person): Person {
        logger.info("Updating one person with Id ${person.id} !")
        val entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundException("Object Not Found") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return repository.save(entity)
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with id $id !")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("Object Not Found") }
        repository.delete(entity)
    }
}

