package com.feint.user_manager.controller

import com.feint.user_manager.pojo.User
import com.feint.user_manager.service.InfoService
import com.feint.user_manager.service.LoginService
import com.feint.user_manager.service.RegisterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UserController{
    @Autowired
    lateinit var loginService:LoginService

    @Autowired
    lateinit var registerService:RegisterService

    @Autowired
    lateinit var infoService:InfoService

    @PostMapping("/user/sign-up")
    fun register(@RequestBody user: User)=registerService.register(user)

    @PostMapping("/user/sign-in")
    fun login(@RequestBody user:User)=loginService.login(user)

    @GetMapping("/user/info/{uid}")
    fun userInfo(@PathVariable("uid")uid:Long)=infoService.getUserInfo(uid)
}