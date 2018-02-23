package com.feint.user_manager.service

import com.feint.user_manager.mapper.UserInfoMapper
import com.feint.user_manager.mapper.UserMapper
import com.feint.user_manager.pojo.User
import com.feint.user_manager.pojo.response.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LoginService{
    @Autowired
    lateinit var userMapper: UserMapper

    @Autowired
    lateinit var userInfoMapper: UserInfoMapper

    fun login(user: User):Response<User>{
        val findUser:User?=userMapper.findUserByNickOrEmail(if (user.email.length==0) user.nickname else user.email)
        return when {
            findUser==null->Response(user, Response.USER_NO_USER)
            findUser.password != user.password -> Response(findUser, Response.USER_PSD_WRONG)
            else -> {
                val userInfo=userInfoMapper.findUserInfoByUid(findUser.id)
                if(userInfo==null)
                    userInfoMapper.addDefaultUserInfo(findUser.id)

                Response(findUser, Response.SUCCESS)
            }
        }
    }


}