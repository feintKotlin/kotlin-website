package com.feint.feintkotlin_server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer
import org.springframework.cloud.netflix.feign.EnableFeignClients

@SpringBootApplication
@EnableEurekaServer
@EnableFeignClients
class FeintkotlinServerApplication

fun main(args: Array<String>) {
    SpringApplication.run(FeintkotlinServerApplication::class.java, *args)
}
