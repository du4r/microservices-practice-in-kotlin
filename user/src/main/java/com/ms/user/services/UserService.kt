package com.ms.user.services

import com.ms.user.models.UserModel
import com.ms.user.producers.UserProducer
import com.ms.user.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    var userRepository: UserRepository,
    var userProducer: UserProducer
) {

    @Transactional
    fun save(userModel: UserModel): UserModel {
        userRepository.save(userModel)
        userProducer.publishMessageEmail(userModel)
        return userModel
    }

}