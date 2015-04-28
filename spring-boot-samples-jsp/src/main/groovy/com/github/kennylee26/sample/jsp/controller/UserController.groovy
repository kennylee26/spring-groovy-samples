package com.github.kennylee26.sample.jsp.controller

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * <p>Created on 27/4/15.</p>
 * @author kennylee
 */
@Controller
@Scope("prototype")
class UserController {

    @RequestMapping(value = "/user/{name}", method = [RequestMethod.GET])
    public String hello(@PathVariable("name") String name, Map<String, Object> model) {
        model.put('user', new User(name: name))
        return "home"
    }
}
