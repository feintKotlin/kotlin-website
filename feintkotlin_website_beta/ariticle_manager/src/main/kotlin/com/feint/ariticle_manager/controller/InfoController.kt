package com.feint.ariticle_manager.controller

import com.feint.ariticle_manager.service.InfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class InfoController {
    @Autowired
    lateinit var infoService:InfoService

    @GetMapping("/article/support/add/{aid}")
    fun addArticleSupport(@PathVariable("aid")aid:Long)=
                infoService.addArticleSupport(aid)

    @GetMapping("/article/support/num/{aid}")
    fun getSupportNum(@PathVariable("aid")aid: Long)=infoService.getArticleNum(aid)

    @GetMapping("/article/info/{aid}")
    fun getArticleReadNum(@PathVariable("aid")aid: Long)=infoService.getArticleInfo(aid)
}