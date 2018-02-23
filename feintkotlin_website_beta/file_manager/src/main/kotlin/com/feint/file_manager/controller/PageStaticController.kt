package com.feint.file_manager.controller

import com.feint.file_manager.pojo.Article
import com.feint.file_manager.service.PageStaticService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class PageStaticController{
    @Autowired
    lateinit var pageStaticService:PageStaticService

    @PostMapping("/pages/static")
    fun staticPage(@RequestBody article:Article)=pageStaticService.staticPage(article)
//
//    @GetMapping("/pages/static/all/{token}")
//    fun staticAllPage(@PathVariable("token")token:String)=pageStaticService
}