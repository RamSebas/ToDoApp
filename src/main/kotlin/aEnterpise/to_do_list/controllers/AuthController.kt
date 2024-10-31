package aEnterpise.to_do_list.controllers

import aEnterpise.to_do_list.dto.AuthLoginRequest
import aEnterpise.to_do_list.dto.AuthRegisterRequest
import aEnterpise.to_do_list.service.UserDetailServiceImpl
import aEnterpise.to_do_list.service.UserService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(@Autowired private val userDetailsService: UserDetailServiceImpl,
                     @Autowired private val userService: UserService
) {

    @PostMapping("/register")
    fun register(@Valid @RequestBody authRegister: AuthRegisterRequest): ResponseEntity<Any> {
        if(userService.existsByEmail(authRegister.email))
            return ResponseEntity(mapOf("message" to "This email already exists"), HttpStatus.BAD_REQUEST)

        return ResponseEntity(this.userDetailsService.registerUser(authRegister), HttpStatus.CREATED)

    }

    @PostMapping("/login")
    fun login(@Valid @RequestBody authLogin: AuthLoginRequest): ResponseEntity<Any> {
        return try {
            ResponseEntity(this.userDetailsService.loginUser(authLogin), HttpStatus.OK)
        } catch (e: NoSuchElementException) {
            ResponseEntity(mapOf("message" to "User or password invalid"), HttpStatus.BAD_REQUEST)
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(ex: MethodArgumentNotValidException): ResponseEntity<Map<String, String?>> {
        val errors = ex.bindingResult.fieldErrors.associate { it.field to it.defaultMessage }
        return ResponseEntity(errors, HttpStatus.BAD_REQUEST)
    }
}