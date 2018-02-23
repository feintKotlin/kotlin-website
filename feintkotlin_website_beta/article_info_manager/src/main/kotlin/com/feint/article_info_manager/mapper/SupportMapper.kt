package com.feint.article_info_manager.mapper

import com.feint.article_info_manager.pojo.Support
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface SupportMapper {
    @Insert("INSERT INTO support(aid,uid) VALUES(#{aid},#{uid})")
    fun addSupport(@Param("aid")aid:Long,@Param("uid")uid:Long)

    @Select("Select * from support where aid=#{aid} AND uid=#{uid}")
    fun findSupportByAidAndUid(@Param("aid")aid: Long,@Param("uid")uid: Long):Support
}