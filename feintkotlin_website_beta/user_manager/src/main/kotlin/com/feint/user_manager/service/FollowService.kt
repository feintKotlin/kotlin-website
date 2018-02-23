package com.feint.user_manager.service

import com.feint.user_manager.mapper.FollowMapper
import com.feint.user_manager.mapper.UserInfoMapper
import com.feint.user_manager.mapper.UserMapper
import com.feint.user_manager.pojo.response.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FollowService {
    @Autowired
    lateinit var followMapper:FollowMapper

    @Autowired
    lateinit var userMapper:UserMapper

    @Autowired
    lateinit var userInfoMapper:UserInfoMapper

    fun followAuthor(uid:Long,fuid:Long):Response<String>{
        val user=userMapper.findUserById(uid)
        if(user==null)
            return Response("",Response.USER_NO_USER)
        val fuser=userMapper.findUserById(uid)
        if(fuser==null)
            return Response("",Response.USER_NO_USER)
        if(followMapper.findFollowByUidAndFuid(uid, fuid)!=null)
        {
            followMapper.delFollow(uid,fuid)
            userInfoMapper.updateFollowNumByUid(fuid,-1)
        }else {
            followMapper.addFollow(uid, fuid)
            userInfoMapper.updateFollowNumByUid(fuid, 1)
        }

        return Response("",Response.SUCCESS)
    }

    fun followCount(uid: Long):Response<Int>{
        if(userMapper.findUserById(uid)==null)
            return Response(-1,Response.USER_NO_USER)

        return Response(userInfoMapper.findFollowByUid(uid),Response.SUCCESS)
    }

    fun  isFollowed(uid: Long, fuid: Long): Response<Boolean> {
        val follow=followMapper.findFollowByUidAndFuid(uid,fuid)
        return if(follow==null||follow.id<=0)
            Response(false,Response.SUCCESS)
        else
            Response(true,Response.SUCCESS)
    }
}