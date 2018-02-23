package com.feint.file_manager.mapper

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface ResPathMapper {
    @Select("Select path from res_path")
    fun findAllPath():List<String>
}