package com.ms.email.models

import com.ms.email.enums.StatusEmail
import jakarta.persistence.*


import java.io.Serializable
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "TB_EMAILS")
data class EmailModel(
    private val serialVersionUID: Long = 1L,

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var emailId: UUID?,
    var userId: UUID,
    var emailFrom: String?,
    var emailTo: String,
    var subject: String,
    @Column(columnDefinition = "TEXT")
    var text: String,
    var sendDateEmail: LocalDateTime,
    var statusEmail: StatusEmail?
): Serializable
