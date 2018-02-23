package com.feint.page_static_manager.controller

import com.feint.page_static_manager.service.PageStaticService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PageStaticController {
    @Autowired
    lateinit var pageStaticService:PageStaticService

    @GetMapping("/page/static/all")
    fun staticPage()=pageStaticService.staticPage()
}