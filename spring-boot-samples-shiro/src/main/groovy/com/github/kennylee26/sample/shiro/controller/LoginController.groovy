package com.github.kennylee26.sample.shiro.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * <p> 登录控制器 </p>
 * <p>Created on 24/1/15.</p>
 * @author kennylee
 */
@Controller
class LoginController {

    @RequestMapping("/login")
    def login() {
    }

    @RequestMapping("/")
    def home() {
        "redirect:login"
    }

}
