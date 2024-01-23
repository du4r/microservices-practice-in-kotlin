package com.ms.user.controllers

import com.ms.user.dtos.UserDTO
import com.ms.user.models.UserModel
import com.ms.user.services.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
open class UserController(
    val userService: UserService
) {
    @PostMapping("/users")
    fun saveUser(@RequestBody @Valid userDTO: UserDTO): ResponseEntity<UserModel> {
        val userModel = userDTO.toUserModel()
        val savedUser = userService.save(userModel)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser)
    }
}