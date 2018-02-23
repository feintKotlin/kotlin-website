package com.feint.ariticle_manager.controller

import com.feint.ariticle_manager.pojo.Article
import com.feint.ariticle_manager.service.ManagerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ManagerController{
    @Autowired
    lateinit var managerService:ManagerService

    @GetMapping("/article/manager/uncheck/all")
    fun getAllUnCheckArticle()=managerService.getUncheckArticle()

    @GetMapping("/article/manager/read/{id}")
    fun lokThroughArticle(@PathVariable("id")id:Long):Article=
            managerService.lookThroughArticle(id)

    @PostMapping("/article/manager/check")
    fun articleChecked(@RequestBody article: Article)=
            managerService.articleChecked(article.id,article.intro,article.tag)

    @PostMapping("/article/manager/nocheck")
    fun articleNoChecked(@RequestBody article:Article)=
            managerService.articleNoChecked(article.id,article.intro)
}