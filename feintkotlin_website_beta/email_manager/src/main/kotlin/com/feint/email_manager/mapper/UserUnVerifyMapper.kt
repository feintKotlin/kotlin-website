package com.feint.email_manager.mapper

import com.feint.email_manager.pojo.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface UserUnVerifyMapper {
    /**
     * # 带引号
     * $ 不带引号
     */
    @Select("select *from user_unverify where email=#{email}")
    fun findUserByEmail(@Param("email")email:String): User
}