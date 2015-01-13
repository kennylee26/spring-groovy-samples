package com.github.kennylee26.sample.jpa

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

/**
 * <p>Created on 11/1/15.</p>
 * @author kennylee
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
class DataJpaApplication {

    static void main(String[] args) {
        SpringApplication.run DataJpaApplication, args
    }
}
