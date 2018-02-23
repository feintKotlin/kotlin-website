package com.feint.user_manager.mapper

import com.feint.user_manager.pojo.Follow
import org.apache.ibatis.annotations.*

@Mapper
interface FollowMapper {
    @Insert("Insert into follow(uid,fuid) values(#{uid},#{fuid})")
    fun addFollow(@Param("uid")uid:Long,@Param("fuid")fuid:Long)

    @Select("Select *from follow where uid=#{uid} AND fuid=#{fuid}")
    fun findFollowByUidAndFuid(@Param("uid")uid: Long,@Param("fuid")fuid: Long):Follow

    @Delete("Delete from follow where uid=#{uid} AND fuid=#{fuid}")
    fun delFollow(@Param("uid")uid:Long,@Param("fuid")fuid:Long)
}