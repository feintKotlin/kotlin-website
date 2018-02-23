package com.feint.ariticle_manager.controller

import com.feint.ariticle_manager.service.TopicService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TopicController{
    @Autowired
    lateinit var topicService:TopicService

    @GetMapping("article/topic/all/{type}")
    fun getAllTopic(@PathVariable("type")type:Int)=
            topicService.getAllTopic(type.toByte())
}