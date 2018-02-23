package com.feint.ariticle_manager.client

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod


@FeignClient("user-manager")
interface UserClient{
    @RequestMapping(value = "/user/read/add/{uid}",method = arrayOf(RequestMethod.GET))
    fun addUserReadNum(@PathVariable("uid")uid:Long)
}