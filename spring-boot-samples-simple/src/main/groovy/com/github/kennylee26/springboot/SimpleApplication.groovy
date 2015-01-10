package com.github.kennylee26.springboot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan
@EnableAutoConfiguration
class SimpleApplication {

    static void main(String[] args) {
        SpringApplication.run SimpleApplication, args
    }
}
