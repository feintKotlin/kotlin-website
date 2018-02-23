package com.feint.ariticle_manager.controller

import com.feint.ariticle_manager.mapper.ArticleMapper
import com.feint.ariticle_manager.pojo.Article
import com.feint.ariticle_manager.pojo.response.Response
import com.feint.ariticle_manager.service.ArticleService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ArticleController{

    @Autowired
    lateinit var articleMapper:ArticleMapper

    @Autowired
    lateinit var articleService:ArticleService

    @GetMapping("/article/all")
    fun allArticle():List<Article> = articleMapper.findAllArticle()

    @GetMapping("/article/top25")
    fun top25Article():List<Article> = articleService.getTop25Article()

    @GetMapping("/article/top/{page}")
    fun topArticleWithPage(@PathVariable("page")page: Int)=articleService.getTopArticleWithPage(page)

    @GetMapping("/article/top5/{type}")
    fun topFiveArticle(@PathVariable("type")type:Int):List<Article> =
            articleService.getTopFiveArticleByType(type.toByte())

    @GetMapping("/article/top5/{type}/{topic}")
    fun topFiveArticle(@PathVariable("type")type:Int, @PathVariable("topic")topic:Int)=
            articleService.getTopFiveArticleByTypeAndTopic(type.toByte(),topic.toByte())

    @GetMapping("/article/{type}/{topic}/{page}")
    fun getArticle(@PathVariable("type")type:Byte,
                   @PathVariable("page")page:Int,
                   @PathVariable("topic")topic: Byte)=
            articleService.getArticleByType(type,page,topic)

    @GetMapping("/article/topic-name/{type}/{topic}/{page}")
    fun getArticle(@PathVariable("type")type:Byte,
                   @PathVariable("page")page:Int,
                   @PathVariable("topic")topic: String)=
            articleService.getArticleByTypeAndTopicName(type,page,topic)

    @GetMapping("/article/detail/{id}")
    fun getArticleDetail(@PathVariable("id")id:Long):Article=
            articleService.getArticleDetail(id)

    @GetMapping("article/detail/full/{id}")
    fun getArticleFullDetail(@PathVariable("id")id: Long)=articleService.getArticleFullDetail(id)

    @PostMapping("/article/commit")
    fun commitArticle(@RequestBody article: Article)=articleService.commitArticle(article)

    @GetMapping("/article/uncheck/{page}")
    fun uncheckArticle(@PathVariable("page")page:Int){}

    @GetMapping("/article/check/{aid}/{check}/{opinion}")
    fun checkArticle(@PathVariable("aid")aid:Int,
                     @PathVariable("check")check:Byte,
                     @PathVariable("opinion")opinion:String){}

}