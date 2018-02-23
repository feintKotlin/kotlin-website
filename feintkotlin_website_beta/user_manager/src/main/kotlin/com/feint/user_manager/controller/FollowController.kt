package com.feint.user_manager.controller

import com.feint.user_manager.service.FollowService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FollowController{
    @Autowired
    lateinit var followService:FollowService

    @GetMapping("/user/follow/{uid}/{fuid}")
    fun followAuthor(@PathVariable("uid")uid:Long,
                     @PathVariable("fuid")fuid:Long)= followService.followAuthor(uid,fuid)
    @GetMapping("/user/follow/count/{uid}")
    fun followCount(@PathVariable("uid")uid:Long)=followService.followCount(uid)

    @GetMapping("/user/follow/followed/{uid}/{fuid}")
    fun isFollowed(@PathVariable("uid")uid: Long,
                   @PathVariable("fuid")fuid: Long)=followService.isFollowed(uid,fuid)
}