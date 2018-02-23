package com.feint.page_static_manager

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class PageStaticManagerApplication

fun main(args: Array<String>) {
    SpringApplication.run(PageStaticManagerApplication::class.java, *args)
}
