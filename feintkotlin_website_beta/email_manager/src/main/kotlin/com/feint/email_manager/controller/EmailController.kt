package com.feint.email_manager.controller

import com.feint.email_manager.service.EmailSenderService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class EmailController{

    @Autowired
    lateinit var emailService:EmailSenderService



    @GetMapping("/email/valid/{uid}")
    fun send(@PathVariable("uid")uid:Long)=emailService.validEmail(uid)


    @GetMapping("/email/validate/{token}")
    fun validate(@PathVariable("token")token:String)="validate success"
}