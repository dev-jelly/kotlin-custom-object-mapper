package kr.jellyms.kotlinobjectmapper.controller

import kr.jellyms.kotlinobjectmapper.controller.TodoController.Companion.RESOURCES_PREFIX
import kr.jellyms.kotlinobjectmapper.dto.TodoDto
import kr.jellyms.kotlinobjectmapper.model.Todo
import kr.jellyms.kotlinobjectmapper.service.TodoService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(RESOURCES_PREFIX)
class TodoController(val todoService: TodoService) {
    companion object {
        const val RESOURCES_PREFIX = "/todos"
        val logger = LoggerFactory.getLogger(this.javaClass)!!
    }

    @PostMapping("")
    fun create(@RequestBody todo: TodoDto.Create): ResponseEntity<Todo> {
        logger.info("{}", todo)
        val created = todoService.create(todo)
        return ResponseEntity(created, HttpStatus.CREATED)
    }

}
