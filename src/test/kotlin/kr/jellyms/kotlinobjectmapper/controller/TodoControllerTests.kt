package kr.jellyms.kotlinobjectmapper.controller

import com.fasterxml.jackson.databind.ObjectMapper
import kr.jellyms.kotlinobjectmapper.dto.TodoDto
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.jackson.JsonObjectSerializer
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
class TodoControllerTests{
    @Autowired
    lateinit var mvc: MockMvc

    @Test
    fun `Create Todo with parameters have whitespaces on head or tail`() {
        val todo = TodoDto.Create(
                title = "    this is title    ",
                description = "        thshshishhshsihis is description     ",
                done = false
        )

        val trimTitle = todo.title.trim()
        val trimDescription = todo.description.trim()

        val mapper = ObjectMapper()
        val json = mapper.writeValueAsString(todo)

        mvc.perform(post(TodoController.RESOURCES_PREFIX)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                .andExpect(status().isCreated)
                .andExpect(content()
                            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title", equalTo(trimTitle)))
                .andExpect(jsonPath("$.description", equalTo(trimDescription)))
                .andExpect(jsonPath("$.done", equalTo(todo.done)))
    }

}