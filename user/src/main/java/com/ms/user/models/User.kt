package com.ms.user.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable
import java.util.UUID

@Entity
@Table(name = "TB_USERS")
data class UserModel(
    private val serialVersionUID: Long = 1L,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val userId: UUID,
    val name: String,
    val email: String
): Serializable
