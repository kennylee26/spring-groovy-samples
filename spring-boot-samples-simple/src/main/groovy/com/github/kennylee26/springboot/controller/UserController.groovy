package com.github.kennylee26.springboot.controller

import com.github.kennylee26.springboot.entity.Users
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * <p>Created UserController on 9/1/15</p>
 * @author kennylee
 */
@RestController
@RequestMapping("/user")
class UserController {

    @RequestMapping(value = "/{id}", method = [RequestMethod.GET])
    def get(@PathVariable("id") String id) {
        def user = new Users()
        user.id = id
        user.name = "kennylee"
        user
    }
}

