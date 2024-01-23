package com.ms.email.services

import com.ms.email.enums.StatusEmail
import com.ms.email.models.EmailModel
import com.ms.email.repositories.EmailRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.MailException
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class EmailService(
    val emailRepository: EmailRepository,
    val emailSender: JavaMailSender
) {

    @Value(value = "\${spring.mail.username}")
    private lateinit var emailFrom: String

    @Transactional
    fun sendEmail(emailModel: EmailModel): EmailModel{
        try {
            emailModel.sendDateEmail = LocalDateTime.now()
            emailModel.emailFrom = emailFrom

            var message = SimpleMailMessage()
            message.setTo(emailModel.emailTo)
            message.setSubject( emailModel.subject)
            message.text = emailModel.text
            emailSender.send(message)

            emailModel.statusEmail = StatusEmail.SENT
        }catch (e: MailException){
            emailModel.statusEmail = StatusEmail.ERROR
        }finally {
           return emailRepository.save(emailModel)
        }
    }
}