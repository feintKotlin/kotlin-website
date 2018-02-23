package com.feint.email_manager

import com.feint.email_manager.utility.EmailUtils
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
class EmailManagerApplication{
    @Bean
    fun emailUtils():EmailUtils=EmailUtils()
}

fun main(args: Array<String>) {
    SpringApplication.run(EmailManagerApplication::class.java, *args)
}
