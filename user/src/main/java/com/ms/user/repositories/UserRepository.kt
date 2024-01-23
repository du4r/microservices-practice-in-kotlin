package com.ms.user.repositories

import com.ms.user.models.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


interface UserRepository: JpaRepository<UserModel, UUID> {
}