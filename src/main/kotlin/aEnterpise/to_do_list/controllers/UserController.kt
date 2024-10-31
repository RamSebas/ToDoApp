package aEnterpise.to_do_list.controllers


import aEnterpise.to_do_list.dto.UserDto
import aEnterpise.to_do_list.model.UserEntity
import aEnterpise.to_do_list.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(@Autowired private val userService: UserService) {

    @GetMapping
    fun getUser(): ResponseEntity<UserEntity> {
        val auth = SecurityContextHolder.getContext().authentication
        val email = auth.name

        return ResponseEntity.ok(userService.findUserByEmail(email))
    }
}
