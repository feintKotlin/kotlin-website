package com.feint.email_manager.client

import com.feint.email_manager.pojo.User
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient("user-manager")
interface UserClient {
    @RequestMapping(value = "/user/info/{uid}",method = arrayOf(RequestMethod.GET))
    fun getUserInfo(@PathVariable("uid")uid:Long):User
}