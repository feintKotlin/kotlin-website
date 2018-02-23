package com.feint.ariticle_manager.pojo

import java.sql.Timestamp

data class Comment(val id:Long=0,
                   var uid:Long=0,
                   var aid:Long=0,
                   var cid:Long=0,
                   var content:String="",
                   var subdate:Timestamp=Timestamp(System.currentTimeMillis()))