package com.feint.user_manager.pojo

import java.util.*

data class UserInfo(val id:Long=0,
                    val uid:Long=0,
                    var follow:Int=0,
                    var through:Int=0,
                    var gender:Byte=0,
                    var prov:String="",
                    var city:String="",
                    var town:String="",
                    var address:String="",
                    var birth:Date=Date())