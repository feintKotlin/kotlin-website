package com.feint.ariticle_manager.mapper

import com.feint.ariticle_manager.pojo.ArticleType
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface TypeMapper{
    @Select("select *from article_type")
    fun findAllTypes():List<ArticleType>
}