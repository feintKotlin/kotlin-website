package com.feint.user_manager.utility

import com.feint.user_manager.pojo.User
import com.feint.user_manager.pojo.response.Response

object UserInfoValidateUtil{
    fun validate(user:User):Pair<Boolean,Response<String>>{
        val emialPair= validateEmail(user.email)
        return if(emialPair.first) return emialPair
        else validateNickName(user.nickname)
    }

    fun validateNickName(nickName:String):Pair<Boolean,Response<String>>{
        val regEx = ".*[\\\\\\;\\*\\?\\-\\+\\&\\^\\$\\#\\@\\!\\\\'\\\"\\.\\,\\/].*"
        if(nickName.matches(Regex(regEx)))
            return Pair(true, Response("",Response.USER_NICKNAME_SPECIAL_CHAR))
        if(nickName.length>30)
            return Pair(true, Response("",Response.USER_NICKNAME_TOO_LONG))
        return Pair(false, Response("",Response.SUCCESS))
    }

    fun validateEmail(email:String):Pair<Boolean,Response<String>>{
        val regex = "^[A-Za-z0-9]{1,40}@[A-Za-z0-9]{1,40}\\.[A-Za-z]{2,3}$"
        if(!email.matches(Regex(regex)))
            return Pair(true,Response("",Response.USER_EMAIL_WRONG_FORMAT))
        return Pair(false, Response("",Response.SUCCESS))
    }
}