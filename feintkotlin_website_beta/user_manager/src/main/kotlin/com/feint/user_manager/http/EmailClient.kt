package com.feint.user_manager.http

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@FeignClient("email-manager")
interface EmailClient{
    @RequestMapping("/email/send/{email}")
    fun sendEmail(@PathVariable("email")email:String)
}