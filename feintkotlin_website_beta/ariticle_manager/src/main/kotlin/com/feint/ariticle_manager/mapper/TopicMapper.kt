package com.feint.ariticle_manager.mapper

import com.feint.ariticle_manager.pojo.ArticleTopic
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface TopicMapper{
    @Select("select * from article_topic where type=#{type}")
    fun selectAllTopicByType(@Param("type")type:Byte):List<ArticleTopic>

    @Select("select * from article_topic where topic=#{topic}")
    fun selectTopicByTopic(@Param("topic")topic:String):ArticleTopic
}