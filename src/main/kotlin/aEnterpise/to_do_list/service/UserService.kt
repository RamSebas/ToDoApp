package aEnterpise.to_do_list.service

import aEnterpise.to_do_list.dto.UserDto
import aEnterpise.to_do_list.model.UserEntity


interface UserService {
    fun findUserByEmail(email: String): UserEntity
    fun existsByEmail(email: String): Boolean
}
