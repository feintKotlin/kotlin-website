package com.feint.user_manager.controller

import com.feint.user_manager.pojo.UserInfo
import com.feint.user_manager.service.UserInfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UserInfoController{
    @Autowired
    lateinit var userInfoService:UserInfoService

    @GetMapping("/user/info/info/{uid}")
    fun userInfoInfo(@PathVariable("uid")uid:Long)=userInfoService.getUserInfo(uid)

    @GetMapping("/user/read/num/{uid}")
    fun userReadNum(@PathVariable("uid")uid: Long)=userInfoService.userReadNum(uid)

    @GetMapping("/user/read/add/{uid}")
    fun addUserReadNum(@PathVariable("uid")uid: Long)=userInfoService.addUserReadNum(uid)

    @PostMapping("/user/info/info/update")
    fun updateInfoInfo(@RequestBody userInfo:UserInfo)=userInfoService.updateUserInfo(userInfo)
}