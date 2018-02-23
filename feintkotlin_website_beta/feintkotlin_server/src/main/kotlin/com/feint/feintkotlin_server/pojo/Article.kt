package com.feint.feintkotlin_server.pojo

import java.sql.Timestamp

data class Article(val id:Long=0,
                   var title:String="",
                   var content:String="",
                   var uid:Long=0,
                   var subdate: Timestamp = Timestamp(System.currentTimeMillis()),
                   var type:Any?=null,
                   var topic:Any?=null,
                   var tag:String="",
                   var chk:Byte=0,
                   var intro:String="")

enum class Chk(val chkState:Byte){
    CHECKED(1),
    CHECKING(2),
    UN_CHECKED(3)
}