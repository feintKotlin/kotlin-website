package com.feint.ariticle_manager.controller

import com.feint.ariticle_manager.service.TagService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TagController{
    @Autowired
    lateinit var tagService:TagService


    @GetMapping("/article/tag/top")
    fun topTag()=tagService.getTopTags()
}