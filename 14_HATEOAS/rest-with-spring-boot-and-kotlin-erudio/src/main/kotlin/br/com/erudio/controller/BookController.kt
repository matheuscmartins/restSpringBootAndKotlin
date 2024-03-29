package br.com.erudio.controller

import br.com.erudio.data.vo.v1.BookVO
import br.com.erudio.services.BookService
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
import kotlin.coroutines.coroutineContext

@RestController
@RequestMapping("/api/book/v1")
@Tag(name = "Books", description = "Endpoints for Managin Books")
class BookController {

    @Autowired
    private lateinit var service: BookService
    // var service: BookService = BookService()

    @GetMapping(produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
   @Operation(summary =  "Find all Books", description = "Find all Books",
       tags = ["Books"],
       responses = [
           ApiResponse(description = "Sucess",
               responseCode = "200",
               content = [
                   Content(array = ArraySchema(schema = Schema(implementation = BookVO::class)))
               ]),
           ApiResponse(description = "No Content",
               responseCode = "204",
               content = [ Content(schema = Schema(implementation = Unit::class))
               ]),
           ApiResponse(description = "Bad Request",
               responseCode = "400",
               content = [ Content(schema = Schema(implementation = Unit::class))
               ]),
           ApiResponse(description = "Unauthorized",
               responseCode = "401",
               content = [ Content(schema = Schema(implementation = Unit::class))
               ]),
           ApiResponse(description = "Not Found",
               responseCode = "404",
               content = [ Content(schema = Schema(implementation = Unit::class))
               ]),
           ApiResponse(description = "Internal Error",
               responseCode = "500",
               content = [ Content(schema = Schema(implementation = Unit::class))
               ]),
       ]
   )
    fun findAll(): List<BookVO> {
        return service.findAll()
    }

    @GetMapping(value = ["/{id}"],
                    produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    @Operation(summary =  "Find a Book", description = "Find a Book",
        tags = ["Books"],
        responses = [
            ApiResponse(description = "Sucess",
                responseCode = "200",
                content = [
                    Content(schema = Schema(implementation = BookVO::class))
                ]),
            ApiResponse(description = "No Content",
                responseCode = "204",
                content = [ Content(schema = Schema(implementation = Unit::class))
                ]),
            ApiResponse(description = "Bad Request",
                responseCode = "400",
                content = [ Content(schema = Schema(implementation = Unit::class))
                ]),
            ApiResponse(description = "Unauthorized",
                responseCode = "401",
                content = [ Content(schema = Schema(implementation = Unit::class))
                ]),
            ApiResponse(description = "Not Found",
                responseCode = "404",
                content = [ Content(schema = Schema(implementation = Unit::class))
                ]),
            ApiResponse(description = "Internal Error",
                responseCode = "500",
                content = [ Content(schema = Schema(implementation = Unit::class))
                ]),
        ]
    )
    fun findById(@PathVariable(value="id") id: Long): BookVO {
        return service.findById(id)
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML],
                produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    @Operation(summary =  "Adds a New Book", description = "Adds a New Book",
        tags = ["Books"],
        responses = [
            ApiResponse(description = "Sucess",
                responseCode = "200",
                content = [
                    Content(schema = Schema(implementation = BookVO::class))
                ]),
            ApiResponse(description = "Bad Request",
                responseCode = "400",
                content = [ Content(schema = Schema(implementation = Unit::class))
                ]),
            ApiResponse(description = "Unauthorized",
                responseCode = "401",
                content = [ Content(schema = Schema(implementation = Unit::class))
                ]),
            ApiResponse(description = "Internal Error",
                responseCode = "500",
                content = [ Content(schema = Schema(implementation = Unit::class))
                ]),
        ]
    )
    fun create(@RequestBody book: BookVO): BookVO {
        return service.create(book)

    }

    @PutMapping(consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML],
                    produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    @Operation(summary =  "Updates a book's information", description = "Updates a book's information",
        tags = ["Books"],
        responses = [
            ApiResponse(description = "Sucess",
                responseCode = "200",
                content = [
                    Content(schema = Schema(implementation = BookVO::class))
                ]),
            ApiResponse(description = "No Content",
                responseCode = "204",
                content = [ Content(schema = Schema(implementation = Unit::class))
                ]),
            ApiResponse(description = "Bad Request",
                responseCode = "400",
                content = [ Content(schema = Schema(implementation = Unit::class))
                ]),
            ApiResponse(description = "Unauthorized",
                responseCode = "401",
                content = [ Content(schema = Schema(implementation = Unit::class))
                ]),
            ApiResponse(description = "Not Found",
                responseCode = "404",
                content = [ Content(schema = Schema(implementation = Unit::class))
                ]),
            ApiResponse(description = "Internal Error",
                responseCode = "500",
                content = [ Content(schema = Schema(implementation = Unit::class))
                ]),
        ]
    )
    fun update(@RequestBody book: BookVO): BookVO {
        return service.update(book)
    }

    @DeleteMapping(value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    @Operation(summary =  "Deletes a book", description = "Deletes a book",
        tags = ["Books"],
        responses = [
            ApiResponse(description = "No Content",
                responseCode = "204",
                content = [ Content(schema = Schema(implementation = Unit::class))
                ]),
            ApiResponse(description = "Bad Request",
                responseCode = "400",
                content = [ Content(schema = Schema(implementation = Unit::class))
                ]),
            ApiResponse(description = "Unauthorized",
                responseCode = "401",
                content = [ Content(schema = Schema(implementation = Unit::class))
                ]),
            ApiResponse(description = "Not Found",
                responseCode = "404",
                content = [ Content(schema = Schema(implementation = Unit::class))
                ]),
            ApiResponse(description = "Internal Error",
                responseCode = "500",
                content = [ Content(schema = Schema(implementation = Unit::class))
                ]),
        ]
    )
    fun delete(@PathVariable(value="id") id: Long) : ResponseEntity<*>{
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}