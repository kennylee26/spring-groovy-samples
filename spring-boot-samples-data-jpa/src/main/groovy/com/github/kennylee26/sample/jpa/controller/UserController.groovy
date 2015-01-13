package com.github.kennylee26.sample.jpa.controller

import com.github.kennylee26.sample.jpa.service.UserService
import org.springframework.context.annotation.Scope
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import javax.annotation.Resource

/**
 * <p>Created on 13/1/15.</p>
 * @author kennylee
 */
@RestController
@Scope("prototype")
@RequestMapping("/user")
class UserController {
    @Resource
    UserService userService

    @RequestMapping(value = "list", method = [RequestMethod.GET])
    def findAll() {
        userService.findAll()
    }
}
