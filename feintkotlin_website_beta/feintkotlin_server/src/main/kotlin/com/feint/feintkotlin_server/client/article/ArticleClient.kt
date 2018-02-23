package com.feint.feintkotlin_server.client.article

import com.feint.feintkotlin_server.pojo.Article
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "article-manager")
interface ArticleClient{
    @GetMapping("/article/top25")
    fun top25Article():List<Article>
}