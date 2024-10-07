package aEnterpise.to_do_list.repository

import aEnterpise.to_do_list.model.ToDo
import aEnterpise.to_do_list.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ToDoRepository : JpaRepository<ToDo, Long> {
    fun findByUser_userID(userID: Long): List<ToDo>
}
