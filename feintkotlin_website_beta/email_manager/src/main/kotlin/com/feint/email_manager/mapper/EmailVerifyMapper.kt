package com.feint.email_manager.mapper

import com.feint.email_manager.pojo.EmailVerify
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface EmailVerifyMapper{
    @Insert("insert into email_verify(uid,token) values(#{emverify.uid},#{emverify.token})")
    fun addEmailVerify(@Param("emverify")emverify:EmailVerify)
}