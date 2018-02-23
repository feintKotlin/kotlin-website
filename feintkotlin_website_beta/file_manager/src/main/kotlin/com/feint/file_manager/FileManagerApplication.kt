package com.feint.file_manager

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class FileManagerApplication

fun main(args: Array<String>) {
    SpringApplication.run(FileManagerApplication::class.java, *args)
}
