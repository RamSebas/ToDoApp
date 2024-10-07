package aEnterpise.to_do_list.service

import aEnterpise.to_do_list.dto.UserDto
import aEnterpise.to_do_list.model.User


interface UserService {
    fun registerUser(userDto: UserDto): User
    fun findByUsername(username: String): User?
    fun findByEmail(email: String): User?
}
