package com.ms.user.dtos

import com.ms.user.models.UserModel
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import java.util.*

data class UserDTO(@NotBlank val name: String, @NotBlank @Email val email: String){
    fun toUserModel(): UserModel{
        return UserModel(
            userId = UUID.randomUUID(),
            name = name,
            email = email
        )
    }
}
