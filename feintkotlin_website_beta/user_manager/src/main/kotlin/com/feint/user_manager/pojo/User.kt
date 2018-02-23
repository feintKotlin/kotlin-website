package com.feint.user_manager.pojo

/**
 * tag中的每一项使用';'（英文分号）分隔。
 * type表示账号类型，目前只有本站账号。
 * protrait是用户头像的文件名称，使用32位的MD5值来进行表示。
 */
data class User(
        val id:Long=0,
        var nickname:String="",
        var password:String="",
        var email:String="",
        var protrait:String="",
        var descrip:String="",
        var tag:String="",
        var type:Int=0,
        var chk:Byte=0)