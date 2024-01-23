package com.ms.user.producers

import com.ms.user.dtos.EmailDTO
import com.ms.user.models.UserModel
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class UserProducer(
    val rabbitTemplate: RabbitTemplate
) {

    @Value("\${broker.queue.email.name}")
    private lateinit var routingKey: String

    fun publishMessageEmail(userModel: UserModel){
        var emailDTO = EmailDTO(
            userModel.userId,
            userModel.email,
            "Cadastro realizado com sucesso",
            userModel.name+ ", Seja bem vindo(a) a plataforma! \nAgradecemos o seu cadastro"
            )
        rabbitTemplate.convertAndSend("", routingKey,emailDTO)
    }
}