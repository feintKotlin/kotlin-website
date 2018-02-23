package com.feint.user_manager.mapper

import com.feint.user_manager.pojo.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface UserMapper {
    @Select("select * from user where nickname=#{identify} OR email=#{identify}")
    fun findUserByNickOrEmail(@Param("identify")identify:String):User

    @Select("select * from user where id=#{identify}")
    fun findUserById(@Param("identify")identify:Long):User

    @Insert("Insert into user(nickname,email,password,protrait) values(#{nickname},#{email},#{password},#{protrait})")
    fun addUser(@Param("nickname")nickname:String,
                @Param("email")email:String,
                @Param("password")password:String,
                @Param("protrait")protrait:String)
}