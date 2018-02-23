package com.feint.page_static_manager.mapper

import com.feint.page_static_manager.pojo.Article
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface ArticleMapper{
    @Select("Select * from article")
    fun findAllArticle():List<Article>

    @Select("SELECT a.id,a.title,a.content,t.topic,a.tag,a.type FROM article a,article_topic t WHERE a.chk=#{check} AND a.topic=t.id  order by a.subdate desc")
    fun findAllArticleByChk(@Param("check")check:Byte):List<Article>
}