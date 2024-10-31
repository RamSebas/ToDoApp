package aEnterpise.to_do_list.dto

data class UserDto(
    val userID: Long = 0,
    val username: String,
    val email: String,
    val password: String
)