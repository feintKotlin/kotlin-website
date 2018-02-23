package com.feint.ariticle_manager.pojo

import java.sql.Timestamp

data class CommentManager(val aid:Long=0,
                          val title:String="",
                          val cid:Long=0,
                          val commContnent:String="",
                          val uid:Long=0,
                          val subdate:Timestamp= Timestamp(System.currentTimeMillis()))