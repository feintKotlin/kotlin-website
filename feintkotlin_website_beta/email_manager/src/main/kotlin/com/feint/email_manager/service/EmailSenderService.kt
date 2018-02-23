package com.feint.email_manager.service

import com.feint.email_manager.client.UserClient
import com.feint.email_manager.mapper.EmailVerifyMapper
import com.feint.email_manager.mapper.UserUnVerifyMapper
import com.feint.email_manager.pojo.EmailVerify
import com.feint.email_manager.pojo.response.Response
import com.feint.email_manager.utility.EmailUtils
import com.netflix.discovery.converters.Auto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service
import java.util.*


@Service
class EmailSenderService{

    @Autowired
    lateinit var emailVerifyMapper:EmailVerifyMapper

    @Autowired
    lateinit var userClient:UserClient

    @Autowired
    lateinit var emailUtil:EmailUtils

    @Value(value = "\${spring.mail.username}")
    lateinit var sender:String

    fun validEmail(uid:Long):Response<String>{
        val user= userClient.getUserInfo(uid)
        val token=UUID.randomUUID().toString()
        if(user== null)
            return Response("",Response.USER_NO_USER)
        if(user.chk==1.toByte())
            return Response("",Response.USER_EMAIL_VALIDATED)
        val emailVerify=EmailVerify(uid=user.id,
                token = token)
        emailVerifyMapper.addEmailVerify(emailVerify)
        emailUtil.sendValidateEmail(user,sender,token)
        return Response("",Response.SUCCESS)
    }
}