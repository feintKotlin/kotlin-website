package com.feint.ariticle_manager.pojo.response

class Response<T>(val data:T,val req:Req){

    class Req(val code:Int,val msg:String)

    companion object {
        /**
         * user
         */
        val USER_NO_USER=Req(601,"用户不存在")
        val USER_PSD_WRONG=Req(602,"密码错误")
        val SUCCESS=Req(200,"请求成功")
        /**
         * article
         */
        val ARTICLE_INCORRECT_CHAR=Req(621,"存在非法字符（可能是emoji表情）")
        val ARTICLE_NONE=Req(622,"文章不存在")
        /**
         * article info
         */
        val SUPPORT_HAVING=Req(631,"已经点过赞")

    }
}