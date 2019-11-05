package kr.jellyms.kotlinobjectmapper.repository

import kr.jellyms.kotlinobjectmapper.model.Todo
import org.springframework.data.repository.CrudRepository

interface TodoRepository: CrudRepository<Todo, Long>{

}
