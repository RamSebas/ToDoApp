package aEnterpise.to_do_list.repository


import aEnterpise.to_do_list.model.Task
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository: JpaRepository<Task, Long> {

    fun findByUserId(userId: Long, pageable: Pageable): Page<Task>
    fun countByUserId(userId: Long): Int
}