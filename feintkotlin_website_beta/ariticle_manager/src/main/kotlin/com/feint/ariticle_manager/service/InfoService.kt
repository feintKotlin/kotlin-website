package com.feint.ariticle_manager.service

import com.feint.ariticle_manager.mapper.ArticleMapper
import com.feint.ariticle_manager.mapper.InfoMapper
import com.feint.ariticle_manager.pojo.ArticleInfo
import com.feint.ariticle_manager.pojo.response.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class InfoService {
    @Autowired
    lateinit var infoMapper:InfoMapper

    @Autowired
    lateinit var articleMapper:ArticleMapper

    fun addArticleSupport(aid:Long){
        val info=infoMapper.findInfoByAid(aid)
        if(info==null||info.aid==0L)
            infoMapper.addInfo(aid)
        infoMapper.updateInfoSupport(aid,1)
    }

    fun getArticleNum(aid:Long):Response<Int>{
        val article=articleMapper.findArticleById(aid)
        if(article==null)
            return Response<Int>(-1, Response.ARTICLE_NONE)
        val info=infoMapper.findInfoByAid(aid)
        if(info==null)
            return Response<Int>(0, Response.SUCCESS)
        return Response(info.support,Response.SUCCESS)
    }

    fun getArticleInfo(aid: Long):Response<ArticleInfo>{
        val articleInfo=infoMapper.findInfoByAid(aid)
        return if(articleInfo==null)
            Response(ArticleInfo(),Response.ARTICLE_NONE)
        else
            Response(articleInfo,Response.SUCCESS)
    }
}