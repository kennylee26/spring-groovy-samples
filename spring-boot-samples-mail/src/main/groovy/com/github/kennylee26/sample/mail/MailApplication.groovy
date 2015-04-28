package com.github.kennylee26.sample.mail

import org.apache.velocity.app.VelocityEngine
import org.apache.velocity.exception.VelocityException
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.ui.velocity.VelocityEngineFactoryBean

@SpringBootApplication
class MailApplication {
    static void main(String[] args) {
        SpringApplication.run MailApplication, args
    }

    @Bean
    public VelocityEngine velocityEngine() throws VelocityException, IOException {
        VelocityEngineFactoryBean factory = new VelocityEngineFactoryBean();
        Properties props = new Properties();
        props.put("resource.loader", "class");
        props.put("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader." +
                        "ClasspathResourceLoader");
        factory.setVelocityProperties(props);
        return factory.createVelocityEngine();
    }
}
