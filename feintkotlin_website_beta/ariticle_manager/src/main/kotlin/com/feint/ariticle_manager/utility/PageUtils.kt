package com.feint.ariticle_manager.utility

object PageUtils{
    val PER_PAGE_NUM=15
    fun toPage(page:Int,perPageNum:Int= PER_PAGE_NUM):Pair<Int,Int>{
        return Pair<Int,Int>((page-1)* perPageNum,perPageNum)
    }
}