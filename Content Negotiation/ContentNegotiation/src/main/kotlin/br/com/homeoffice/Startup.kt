package br.com.homeoffice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Startup

fun main(args: Array<String>) {
    runApplication<Startup>(*args)
    //http://localhost:8080/sum/1/2
    // sum, subtraction, division, multiplication or mean

    // mvn clean package spring-boot:run -DskipTests

    //mvn flyway:migrate
}
