package com.feint.ariticle_manager.mapper

import com.feint.ariticle_manager.pojo.ArticleInfo
import org.apache.ibatis.annotations.*

@Mapper
interface InfoMapper {
    @Update("Update article_info set support=support+#{num} where aid=#{aid}")
    fun updateInfoSupport(@Param("aid")aid: Long, @Param("num")num:Int)

    @Update("Update article_info set through=through+#{num} where aid=#{aid}")
    fun updateInfoRead(@Param("aid")aid:Long,@Param("num")num: Int)

    @Select("Select * from article_info where aid=#{aid}")
    fun findInfoByAid(@Param("aid")aid:Long):ArticleInfo

    @Insert("Insert into article_info(aid) values(#{aid})")
    fun addInfo(@Param("aid")aid: Long)

}