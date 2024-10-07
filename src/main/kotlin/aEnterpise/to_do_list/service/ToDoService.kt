package aEnterpise.to_do_list.service

import aEnterpise.to_do_list.dto.ToDoRequest
import aEnterpise.to_do_list.model.ToDo

interface ToDoService {
    fun createToDo(toDoRequest: ToDoRequest): ToDo
    fun findByUserId(userId: Long): List<ToDo>
    fun deleteToDo(taskId: Long)
}
