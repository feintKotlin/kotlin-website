package com.feint.ariticle_manager.service

import com.feint.ariticle_manager.client.FileClient
import com.feint.ariticle_manager.mapper.ArticleMapper
import com.feint.ariticle_manager.mapper.InfoMapper
import com.feint.ariticle_manager.pojo.Article
import com.feint.ariticle_manager.pojo.response.Response
import com.netflix.discovery.converters.Auto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ManagerService {
    @Autowired
    lateinit var articleMapper:ArticleMapper

    @Autowired
    lateinit var infoMapper:InfoMapper

    @Autowired
    lateinit var fileClient:FileClient

    fun getUncheckArticle()=articleMapper.findAllArticleByChk(2)

    fun articleChecked(id:Long,content:String,tag:String):Response<String>{
        articleMapper.updateArticleCheckById(1, content, id,tag)
        infoMapper.addInfo(id)
        fileClient.staticPage(articleMapper.findArticleById(id))
        return Response("",Response.SUCCESS)
    }

    fun articleNoChecked(id:Long,content: String):Response<String> {
        articleMapper.updateArticleCheckByIdWithoutTag(3,content,id)
        return Response("",Response.SUCCESS)
    }

    fun lookThroughArticle(id: Long)= articleMapper.findArticleById(id)
}