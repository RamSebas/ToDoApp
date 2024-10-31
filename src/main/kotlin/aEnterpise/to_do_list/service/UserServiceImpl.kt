package aEnterpise.to_do_list.service


import aEnterpise.to_do_list.dto.UserDto
import aEnterpise.to_do_list.model.UserEntity
import aEnterpise.to_do_list.repository.TaskRepository
import aEnterpise.to_do_list.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(@Autowired private val userRepository: UserRepository): UserService {
    override fun findUserByEmail(email: String): UserEntity {
        return userRepository.findUserByEmail(email).orElse(null)
    }

    override fun existsByEmail(email: String): Boolean {
        return userRepository.existsByEmail(email)
    }
}
