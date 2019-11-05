package kr.jellyms.kotlinobjectmapper.service

import kr.jellyms.kotlinobjectmapper.dto.TodoDto
import kr.jellyms.kotlinobjectmapper.dto.toModel
import kr.jellyms.kotlinobjectmapper.model.Todo
import kr.jellyms.kotlinobjectmapper.repository.TodoRepository
import org.springframework.stereotype.Service

@Service
class TodoService(val todoRepository: TodoRepository) {
    fun create(todo: TodoDto.Create): Todo {
        val toCreate: Todo = todo.toModel()
        return todoRepository.save(toCreate)
    }
}

