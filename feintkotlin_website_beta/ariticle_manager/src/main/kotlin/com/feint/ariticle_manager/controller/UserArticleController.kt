package com.feint.ariticle_manager.controller

import com.feint.ariticle_manager.mapper.ArticleMapper
import com.feint.ariticle_manager.pojo.Article
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserArticleController{
    @Autowired
    lateinit var articleMapper:ArticleMapper

    @GetMapping("/article/user/all/{uid}/{chk}")
    fun getAllUserArticleWithCheck(@PathVariable("uid")uid:Long,
                                   @PathVariable("chk")chk:Byte):List<Article> =
            articleMapper.findAllArticleByChkAndUid(chk,uid)
}