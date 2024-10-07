package aEnterpise.to_do_list.controllers


import aEnterpise.to_do_list.dto.UserDto
import aEnterpise.to_do_list.model.User
import aEnterpise.to_do_list.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class UserController(private val userService: UserService) {

    @PostMapping("/register")
    fun registerUser(@RequestBody userDto: UserDto): ResponseEntity<User> {
        val user = userService.registerUser(userDto)
        return ResponseEntity.ok(user)
    }

    @GetMapping("/user/{username}")
    fun getUserByUsername(@PathVariable username: String): ResponseEntity<User> {
        val user = userService.findByUsername(username)
        return if (user != null) {
            ResponseEntity.ok(user)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
