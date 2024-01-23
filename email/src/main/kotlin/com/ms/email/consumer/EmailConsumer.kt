package com.ms.email.consumer


import com.ms.email.dtos.EmailDTO
import com.ms.email.services.EmailService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class EmailConsumer(val emailService: EmailService) {

    @RabbitListener(queues = arrayOf("\${broker.queue.email.name}"))
    fun listenEmailQueue(@Payload emailDTO: EmailDTO){
        var emailModel = emailDTO.toEmailModel()
        emailService.sendEmail(emailModel)
    }
}