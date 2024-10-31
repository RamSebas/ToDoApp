package aEnterpise.to_do_list.controllers

import aEnterpise.to_do_list.model.PaginatedResponse
import aEnterpise.to_do_list.model.Task
import aEnterpise.to_do_list.model.UserEntity
import aEnterpise.to_do_list.service.TaskService
import aEnterpise.to_do_list.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TaskController(@Autowired private val taskService: TaskService,
                     @Autowired private val userService: UserService
) {

    @PostMapping
    fun createTask(@RequestBody task: Task): ResponseEntity<Task> {
        task.user = this.getUser()

        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.saveTask(task))
    }

    @PutMapping("/{idReceived}")
    fun updateTask(@PathVariable idReceived: Long, @RequestBody taskReceived: Task): ResponseEntity<Any> {
        if(!taskService.isExistTask(idReceived)) return ResponseEntity.notFound().build()

        val task = taskService.findTaskById(idReceived)
        if(!taskService.isAuthorizedTask(task, getUser().id)) {
            return ResponseEntity(mapOf("message" to "Forbidden"), HttpStatus.FORBIDDEN)
        }

        val taskUpdated: Task = taskService.saveTask(taskReceived.copy(id = idReceived, user = task.user))

        return ResponseEntity.status(HttpStatus.CREATED).body(taskUpdated)
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: Long): ResponseEntity<Any> {
        if(!taskService.isExistTask(id)) return ResponseEntity.notFound().build()

        val task = taskService.findTaskById(id)
        if(!taskService.isAuthorizedTask(task, getUser().id)) {
            return ResponseEntity(mapOf("message" to "Unauthorized"), HttpStatus.UNAUTHORIZED)
        }

        taskService.deleteTask(id)

        return ResponseEntity.noContent().build()
    }

    @GetMapping
    fun getTasks(@RequestParam page: Int = 1, @RequestParam limit: Int = 10): PaginatedResponse {
        val tasks = taskService.getTasks(getUser().id, page, limit)
        val total = taskService.getTasksTotal(getUser().id)

        val taskResponse = tasks.map { task ->
            Task(
                id = task.id,
                title = task.title,
                description = task.description,
                user = task.user
            )
        }

        return PaginatedResponse(
            data = taskResponse,
            page = page,
            limit = limit,
            total = total
        )
    }

    fun getUser(): UserEntity {
        val auth = SecurityContextHolder.getContext().authentication
        val email = auth.name

        return userService.findUserByEmail(email)
    }
}