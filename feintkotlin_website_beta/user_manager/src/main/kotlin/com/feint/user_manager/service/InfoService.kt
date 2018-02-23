package com.feint.user_manager.service

import com.feint.user_manager.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InfoService {
    @Autowired
    lateinit var userMapper: UserMapper

    fun getUserInfo(uid:Long)=userMapper.findUserById(uid)

}