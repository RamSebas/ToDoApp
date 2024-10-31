package aEnterpise.to_do_list.service

import aEnterpise.to_do_list.dto.ToDoRequest
import aEnterpise.to_do_list.model.Task

interface TaskService {
    fun getTasks(userId: Long, page: Int, limit: Int): MutableIterable<Task>
    fun findTaskById(id: Long): Task
    fun isExistTask(id: Long): Boolean
    fun saveTask(taskEntity: Task): Task
    fun deleteTask(id: Long)
    fun isAuthorizedTask(taskEntity: Task, userId: Long): Boolean
    fun getTasksTotal(userId: Long): Int
}
