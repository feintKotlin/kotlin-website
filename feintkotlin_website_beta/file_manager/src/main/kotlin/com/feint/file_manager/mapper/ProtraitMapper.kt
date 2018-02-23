package com.feint.file_manager.mapper

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface ProtraitMapper {
    @Select("Select filename from protrait")
    fun findAllProtrait():List<String>
}