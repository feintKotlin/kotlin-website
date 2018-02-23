package com.feint.page_static_manager.service

import com.feint.page_static_manager.mapper.ArticleMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.File
import java.nio.charset.Charset

@Service
class PageStaticService{
    val logger=LoggerFactory.getLogger(PageStaticService::class.java)
    @Autowired
    lateinit var articleMapper:ArticleMapper

    val filePath="/Users/feint/Documents/feintKotlin/front-end/FeintKotlin/singles"
    fun staticPage(){
        val modelString= loadModel()
        val tagString = "\$(\"#article-body\").html(marked(\""
        val tagIndex = modelString.indexOf(tagString)
        var beforeString = modelString.slice(0..tagString.length + tagIndex - 1)
        val afterString = modelString.slice(tagString.length + tagIndex..modelString.length - 1)
        val beforelocal=afterString.slice(0..3)
        val afterlocal=afterString.subSequence(4..afterString.length-1)

        val articleList=articleMapper.findAllArticleByChk(1)
        articleList.forEach {
            val file=File("$filePath/${it.id}.html")
            logger.info(it.title)
            val localString="""
                localStorage.currentArticleId=${it.id}
                localStorage.currentTypeId=${it.type}
                localStorage.currentTopic="${it.topic}"
            """
            file.writeText(beforeString+createOnelineText(it.content)+
                    beforelocal+localString+afterlocal)
        }
    }

    fun loadModel():String{
        val modelFile= File("$filePath/model.html")
        return modelFile.readText(Charset.defaultCharset())
    }

    fun createOnelineText(md: String):String {
        var result=""
        md.split('\n').forEach {
            result+=it.replace("\\", "\\\\").replace("\"", "\\\"") + "\\n"
        }
        return result
    }
}