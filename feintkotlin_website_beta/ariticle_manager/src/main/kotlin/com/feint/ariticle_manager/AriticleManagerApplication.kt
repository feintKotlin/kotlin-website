package com.feint.ariticle_manager

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.feign.EnableFeignClients

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
class AriticleManagerApplication

fun main(args: Array<String>) {
    SpringApplication.run(AriticleManagerApplication::class.java, *args)
}
