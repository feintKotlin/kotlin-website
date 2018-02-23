package com.feint.user_manager.service

import com.feint.user_manager.client.FileClient
import com.feint.user_manager.mapper.UserInfoMapper
import com.feint.user_manager.mapper.UserMapper
import com.feint.user_manager.pojo.User
import com.feint.user_manager.pojo.response.Response
import com.feint.user_manager.utility.UserInfoValidateUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class RegisterService {
    @Autowired
    lateinit var userMapper:UserMapper



    @Autowired
    lateinit var fileClient:FileClient

    fun register(user: User):Response<String>{
        val userPair=UserInfoValidateUtil.validate(user)
        if(userPair.first) return userPair.second

        val nick_user=userMapper.findUserByNickOrEmail(user.nickname)
        if(nick_user!=null)
            return Response("",Response.USER_NICKNAME_HAVING)
        val email_user=userMapper.findUserByNickOrEmail(user.email)
        if(email_user!=null)
            return Response("",Response.USER_EMAIL_HAVING)


        val protraitList=fileClient.allProtrait()
        val psize=protraitList.size

        userMapper.addUser(user.nickname,user.email,user.password,
                protraitList[(Math.random()*psize%psize).toInt()])

        return Response("",Response.SUCCESS)
    }
}