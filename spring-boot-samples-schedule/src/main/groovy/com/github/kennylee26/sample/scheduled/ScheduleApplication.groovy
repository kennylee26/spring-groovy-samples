package com.github.kennylee26.sample.scheduled

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class ScheduleApplication {
    static void main(String[] args) {
        SpringApplication.run ScheduleApplication, args
    }
}
