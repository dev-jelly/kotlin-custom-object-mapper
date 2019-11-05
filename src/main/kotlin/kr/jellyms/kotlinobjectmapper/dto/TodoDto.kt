package kr.jellyms.kotlinobjectmapper.dto

import kr.jellyms.kotlinobjectmapper.model.Todo

class TodoDto {
    data class Create(val title: String,
                      val description: String,
                      val done: Boolean)
}

fun TodoDto.Create.toModel() = Todo(
        id = null,
        title = title,
        description = description,
        done = done
)