package com.feint.article_info_manager.service

import com.feint.article_info_manager.client.ArticleClient
import com.feint.article_info_manager.mapper.SupportMapper
import com.feint.article_info_manager.pojo.response.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SupportService {
    @Autowired
    lateinit var supportMapper:SupportMapper

    @Autowired
    lateinit var articleClient:ArticleClient

    fun supportArticle(aid:Long,uid:Long):Response<String>{
        if(supportMapper.findSupportByAidAndUid(aid,uid)!=null)
            return Response<String>("",Response.SUPPORT_HAVING)
        supportMapper.addSupport(aid,uid)
        articleClient.addArticleSupport(aid)
        return Response<String>("",Response.SUCCESS)
    }
}