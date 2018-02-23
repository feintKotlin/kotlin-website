package com.feint.article_info_manager.client

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient("article-manager")
interface ArticleClient {
    @RequestMapping(value = "/article/support/add/{aid}",method = arrayOf(RequestMethod.GET))
    fun addArticleSupport(@PathVariable("aid")aid:Long)
}