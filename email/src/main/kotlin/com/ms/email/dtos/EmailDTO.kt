package com.ms.email.dtos

import com.ms.email.enums.StatusEmail
import com.ms.email.models.EmailModel
import java.time.LocalDateTime
import java.util.UUID

data class EmailDTO(
    val userId:UUID,
    val emailTo:String,
    val subject: String,
    val text: String
){
    fun toEmailModel(): EmailModel {
        return EmailModel(
            emailId = null,
            userId = userId,
            emailFrom = null,
            emailTo = emailTo,
            subject = subject,
            text = text,
            sendDateEmail = LocalDateTime.now(),
            statusEmail = null
        )
    }
}
