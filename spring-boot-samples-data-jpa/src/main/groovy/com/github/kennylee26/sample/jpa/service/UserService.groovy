package com.github.kennylee26.sample.jpa.service
import com.github.kennylee26.sample.jpa.repository.UserRepository
import org.springframework.stereotype.Service

import javax.annotation.Resource
/**
 * <p>Created on 13/1/15.</p>
 * @author kennylee
 */
@Service
class UserService {

    @Resource
    UserRepository userRepository

    def findAll(){
        userRepository.findAll()
    }
}
