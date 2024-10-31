package aEnterpise.to_do_list.service

import aEnterpise.to_do_list.model.Task
import aEnterpise.to_do_list.repository.TaskRepository
import aEnterpise.to_do_list.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class TaskServiceImpl(@Autowired private val taskRepository: TaskRepository,
                  @Autowired private val userRepository: UserRepository): TaskService {

    override fun getTasks(userId: Long, page: Int, limit: Int): MutableIterable<Task> {
        val pageable = PageRequest.of(page - 1, limit)
        return taskRepository.findByUserId(userId, pageable).content
    }

    override fun findTaskById(id: Long): Task {
        return taskRepository.findById(id).orElse(null)
    }

    override fun isExistTask(id: Long): Boolean {
        return taskRepository.existsById(id)
    }

    override fun saveTask(taskEntity: Task): Task {
        return taskRepository.save(taskEntity)
    }

    override fun deleteTask(id: Long) {
        return taskRepository.deleteById(id)
    }

    override fun isAuthorizedTask(taskEntity: Task, userId: Long): Boolean {
        return taskEntity.user.id == userId
    }

    override fun getTasksTotal(userId: Long): Int {
        return taskRepository.countByUserId(userId)
    }
}