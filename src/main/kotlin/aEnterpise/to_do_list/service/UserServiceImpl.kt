package aEnterpise.to_do_list.service


import aEnterpise.to_do_list.dto.UserDto
import aEnterpise.to_do_list.model.User
import aEnterpise.to_do_list.repository.ToDoRepository
import aEnterpise.to_do_list.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val toDoRepository: ToDoRepository
) : UserService {
    @Transactional
    override fun registerUser(userDto: UserDto): User {
        val user = User(
        userID = 0,
        username = userDto.username,
        email = userDto.email,
        password = userDto.password)
        return userRepository.save(user)
    }

    override fun findByUsername(username: String): User? {
        return userRepository.findByUsername(username)
    }

    override fun findByEmail(email: String): User? {
        return userRepository.findByEmail(email)
    }

}
