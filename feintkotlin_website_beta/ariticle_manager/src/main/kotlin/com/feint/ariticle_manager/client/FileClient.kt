package com.feint.ariticle_manager.client

import com.feint.ariticle_manager.pojo.Article
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient("file-manager")
interface FileClient {
    @RequestMapping(value = "/pages/static",method = arrayOf(RequestMethod.POST))
    fun staticPage(article: Article)
}