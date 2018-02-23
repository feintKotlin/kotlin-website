package com.feint.article_info_manager.controller

import com.feint.article_info_manager.service.SupportService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SupportController {
    @Autowired
    lateinit var supportService:SupportService

    @GetMapping("/support/{aid}/{uid}")
    fun supportArticle(@PathVariable("aid")aid:Long,@PathVariable("uid")uid:Long)=
            supportService.supportArticle(aid,uid)
}