package aEnterpise.to_do_list.service

import aEnterpise.to_do_list.dto.ToDoRequest
import aEnterpise.to_do_list.model.ToDo
import aEnterpise.to_do_list.repository.ToDoRepository
import aEnterpise.to_do_list.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class ToDoServiceImpl(
    private val toDoRepository: ToDoRepository,
    private val userRepository: UserRepository
) : ToDoService {

    override fun createToDo(toDoRequest: ToDoRequest): ToDo {
        // Busca el usuario existente por su ID
        val user = userRepository.findById(toDoRequest.userID).orElseThrow {
            IllegalArgumentException("User not found with id: ${toDoRequest.userID}")
        }
        // Crea la tarea asociada al usuario encontrado
        val todo = ToDo(
            title = toDoRequest.title,
            description = toDoRequest.description,
            completed = toDoRequest.completed,
            user = user)

        return toDoRepository.save(todo)
    }

    override fun findByUserId(userId: Long): List<ToDo> {
        return toDoRepository.findByUser_userID(userId)
    }


    override fun deleteToDo(taskId: Long) {
        toDoRepository.deleteById(taskId)
    }
}
