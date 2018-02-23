package com.feint.ariticle_manager.mapper

import com.feint.ariticle_manager.pojo.Tag
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface TagMapper {
    @Select("SELECT * from tag ORDER BY times DESC LIMIT #{start},#{num}")
    fun selectTagPageAndOrderByTimes(@Param("start")start:Int,@Param("num")num:Int):List<Tag>
}