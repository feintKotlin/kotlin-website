package com.feint.ariticle_manager.mapper

import com.feint.ariticle_manager.pojo.Article
import org.apache.ibatis.annotations.*

@Mapper
interface ArticleMapper {
    @Select("SELECT a.id,a.title,a.content,a.uid,a.subdate,t.topic,a.tag FROM article a,article_topic t  WHERE a.topic=t.id")
    fun findAllArticle():List<Article>

    @Select("SELECT a.id,a.title,a.uid,a.subdate,t.topic,a.tag,a.type,a.topic,a.intro FROM article a,article_topic t WHERE a.chk=#{check} AND a.topic=t.id order by a.subdate desc limit #{start},#{num}")
    fun findArticlePage(@Param("check")check:Byte,
                        @Param("start")start: Int,
                        @Param("num")num:Int):List<Article>
    @Select("SELECT a.id,a.title,a.uid,a.subdate,t.topic,a.tag,a.intro FROM article a,article_topic t WHERE a.chk=#{check} AND a.topic=t.id AND a.type=#{type} order by a.subdate desc limit #{start},#{end}")
    fun findArticlePageByType(@Param("check")check:Byte,
                              @Param("type")type:Byte,
                              @Param("start")start:Int,
                              @Param("end")end:Int):List<Article>

    @Select("SELECT a.id,a.chk,a.title,a.content,a.uid,a.subdate,a.type,t.topic,a.tag FROM article a,article_topic t WHERE a.id=#{id} AND a.topic=t.id")
    fun findArticleById(@Param("id")id:Long):Article

    @Select("SELECT a.id,a.chk,a.title,a.uid,a.subdate,a.type,t.topic,a.tag FROM article a,article_topic t WHERE a.id=#{id} AND a.topic=t.id")
    fun findArticleWithoutContentById(@Param("id")id:Long):Article

    @Select("SELECT a.id,a.title,a.uid,a.subdate,t.topic,a.tag,a.intro FROM article a,article_topic t WHERE a.chk=#{check} AND a.topic=t.id AND a.type=#{type} AND a.topic=#{topic}  order by a.subdate desc limit #{start},#{end}")
    fun findArticlePageByTypeAndTopic(@Param("check")check:Byte,
                                      @Param("type")type:Byte,
                                      @Param("topic")topic:Byte,
                                      @Param("start")start:Int,
                                      @Param("end")end:Int):List<Article>

    @Select("SELECT a.id,a.title,a.uid,a.subdate,t.topic,a.tag,ty.type FROM article a,article_topic t,article_type ty WHERE a.chk=#{check} AND a.topic=t.id AND a.type=ty.id order by a.subdate desc")
    fun findAllArticleByChk(@Param("check")check:Byte):List<Article>

    @Select("SELECT a.id,a.title,a.uid,a.subdate,t.topic,a.tag,a.type,a.intro FROM article a,article_topic t,article_type ty WHERE a.chk=#{check} AND a.uid=#{uid} AND a.topic=t.id AND a.type=ty.id order by a.subdate desc")
    fun findAllArticleByChkAndUid(@Param("check")check: Byte,@Param("uid")uid:Long):List<Article>

    @Insert("INSERT INTO article(title,content,uid,type,topic,tag,chk) VALUES(#{a.title},#{a.content},#{a.uid},#{a.type},#{a.topic},#{a.tag},#{a.chk})")
    fun addArticle(@Param("a")article: Article)

    @Update("UPDATE article SET chk=#{check},intro=#{content},tag=#{tag} WHERE id=#{id}")
    fun updateArticleCheckById(@Param("check")check: Byte,
                               @Param("content")content:String,
                               @Param("id")id:Long,
                               @Param("tag")tag:String)

    @Update("UPDATE article SET chk=#{check},intro=#{content} WHERE id=#{id}")
    fun updateArticleCheckByIdWithoutTag(@Param("check")check: Byte,
                               @Param("content")content:String,
                               @Param("id")id:Long)


}