package aEnterpise.to_do_list.controllers

import aEnterpise.to_do_list.dto.ToDoRequest
import aEnterpise.to_do_list.model.ToDo
import aEnterpise.to_do_list.service.ToDoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todo")
class ToDoController(private val toDoService: ToDoService) {

    @PostMapping
    fun createToDo(@RequestBody toDoRequest: ToDoRequest): ResponseEntity<ToDo>{
        val task = toDoService.createToDo(toDoRequest)
        return ResponseEntity.ok(task)
    }

    @GetMapping("/user/{userId}")
    fun getToDosByUserId(@PathVariable userId: Long): ResponseEntity<List<ToDo>> {
        val todos = toDoService.findByUserId(userId)
        return ResponseEntity.ok(todos)
    }

    @DeleteMapping("/{taskId}")
    fun deleteToDo(@PathVariable taskId: Long): ResponseEntity<Void> {
        toDoService.deleteToDo(taskId)
        return ResponseEntity.noContent().build()
    }
}
