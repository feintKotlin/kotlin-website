package com.feint.user_manager.mapper

import com.feint.user_manager.pojo.User
import com.feint.user_manager.pojo.UserInfo
import org.apache.ibatis.annotations.*

@Mapper
interface UserInfoMapper{

    @Insert("Insert into user_info(uid) values(#{uid})")
    fun addDefaultUserInfo(@Param("uid")uid:Long)

    @Select("select * from user_info where uid=#{uid}")
    fun findUserInfoByUid(@Param("uid")uid:Long):UserInfo

    @Update("update user_info set follow=follow+#{num} where uid=#{uid}")
    fun updateFollowNumByUid(@Param("uid")uid:Long,@Param("num")num: Int)

    @Update("update user_info set through=through+#{num} where uid=#{uid}")
    fun updateReadNumByUid(@Param("uid")uid: Long,@Param("num")num:Int)

    @Select("select follow from user_info where uid=#{uid}")
    fun findFollowByUid(@Param("uid")uid: Long):Int

    @Select("select through from user_info where uid=#{uid}")
    fun findReadByUid(@Param("uid")uid: Long):Int

    @Update("update user_info set gender=#{info.gender},prov=#{info.prov},city=#{info.city},town=#{info.town},address=#{info.address},birth=#{info.birth} where uid=#{info.uid}")
    fun updateUserInfooByUid(@Param("info")info:UserInfo)
}