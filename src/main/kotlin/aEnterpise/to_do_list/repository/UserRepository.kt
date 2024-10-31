package aEnterpise.to_do_list.repository

import aEnterpise.to_do_list.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: JpaRepository<UserEntity, Long> {

    fun findUserByEmail(email: String): Optional<UserEntity>
    fun existsByEmail(email: String): Boolean
}
