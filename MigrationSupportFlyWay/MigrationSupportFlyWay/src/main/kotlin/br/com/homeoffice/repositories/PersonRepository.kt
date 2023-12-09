package br.com.homeoffice.repositories

import br.com.homeoffice.model.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long?>
