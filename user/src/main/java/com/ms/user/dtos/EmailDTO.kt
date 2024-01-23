package com.ms.user.dtos

import java.util.UUID

data class EmailDTO(
    val userUUID: UUID,
    val emailTo: String,
    val subject: String,
    val text: String
)
