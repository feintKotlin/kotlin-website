package com.feint.ariticle_manager.service

import com.feint.ariticle_manager.client.UserClient
import com.feint.ariticle_manager.mapper.ArticleMapper
import com.feint.ariticle_manager.mapper.InfoMapper
import com.feint.ariticle_manager.mapper.TopicMapper
import com.feint.ariticle_manager.pojo.Article
import com.feint.ariticle_manager.pojo.response.Response
import com.feint.ariticle_manager.utility.PageUtils
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ArticleService {
    val logger=LoggerFactory.getLogger(ArticleService::class.java)

    @Autowired
    lateinit var articleMapper:ArticleMapper

    @Autowired
    lateinit var topicMapper:TopicMapper

    @Autowired
    lateinit var infoMapper:InfoMapper

    @Autowired
    lateinit var userClient:UserClient

    fun getTop25Article()=articleMapper.findArticlePage(1,0,25)

    fun getTopArticleWithPage(page:Int): Response<List<Article>> {
        val pagePair=PageUtils.toPage(page,5)
        val articleList=articleMapper.findArticlePage(1,pagePair.first,pagePair.second);
        return if(articleList.isEmpty())
            Response(articleList,Response.ARTICLE_NONE)
        else
            Response(articleList,Response.SUCCESS)
    }

    fun getTopFiveArticleByType(type:Byte):List<Article> {
        return articleMapper.findArticlePageByType(1, type, 0, 5)
    }

    fun getTopFiveArticleByTypeAndTopic(type:Byte,topic:Byte):List<Article>{
        return articleMapper.findArticlePageByTypeAndTopic(1,type,topic,0,5)
    }

    fun getArticleByType(type:Byte,page:Int,topic: Byte):List<Article>{
        val pagePair=PageUtils.toPage(page)
        return articleMapper.findArticlePageByTypeAndTopic(1,type,topic,pagePair.first,pagePair.second)
    }

    fun getArticleByTypeAndTopicName(type:Byte,page:Int,topic: String):List<Article>{
        val articleTopic=topicMapper.selectTopicByTopic(topic)
        val pagePair=PageUtils.toPage(page)
        return articleMapper.findArticlePageByTypeAndTopic(1,type,articleTopic.id.toByte(),pagePair.first,pagePair.second)
    }
    fun getArticleDetail(id:Long):Article{
        val article=articleMapper.findArticleWithoutContentById(id)
       // logger.info("article check :${article.chk},${article.title}")
        if(article.chk==1.toByte()) {
            infoMapper.updateInfoRead(id, 1)
            userClient.addUserReadNum(article.uid)
        }
        return article
    }

    fun getArticleFullDetail(id: Long):Response<Article>{
        val article=articleMapper.findArticleById(id)
        return if(article==null)
            Response<Article>(article,Response.ARTICLE_NONE)
        else
            Response(article,Response.SUCCESS)
    }

    fun commitArticle(article: Article){
        article.chk=2
        articleMapper.addArticle(article)
    }
}