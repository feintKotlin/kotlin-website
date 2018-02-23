package com.feint.article_info_manager

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.feign.EnableFeignClients

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
class ArticleInfoManagerApplication

fun main(args: Array<String>) {
    SpringApplication.run(ArticleInfoManagerApplication::class.java, *args)
}
