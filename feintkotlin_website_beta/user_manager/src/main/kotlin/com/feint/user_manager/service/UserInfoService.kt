package com.feint.user_manager.service

import com.feint.user_manager.mapper.UserInfoMapper
import com.feint.user_manager.mapper.UserMapper
import com.feint.user_manager.pojo.UserInfo
import com.feint.user_manager.pojo.response.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserInfoService{
    @Autowired
    lateinit var userInfoMapper:UserInfoMapper;
    @Autowired
    lateinit var userMapper:UserMapper

    fun getUserInfo(uid:Long):Response<UserInfo>{
        val userInfo=userInfoMapper.findUserInfoByUid(uid)
        var req:Response.Req
        if(userInfo==null)
            req=Response.USER_NO_USER
        req=Response.SUCCESS

        return Response(userInfo,req)
    }
    fun userReadNum(uid: Long):Response<Int>{
        val userInfo=userInfoMapper.findUserInfoByUid(uid)
        return if(userInfo==null)
            Response(-1,Response.USER_NO_USER)
        else
            Response(userInfo.through,Response.SUCCESS)
    }

    fun addUserReadNum(uid: Long)=userInfoMapper.updateReadNumByUid(uid,1)

    fun updateUserInfo(userInfo: UserInfo):Response<String>{
        if(userMapper.findUserById(userInfo.uid)==null)
            return Response("",Response.USER_NO_USER)
        userInfoMapper.updateUserInfooByUid(userInfo)

        return Response("",Response.SUCCESS)
    }
}