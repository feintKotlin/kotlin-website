package com.feint.ariticle_manager.service

import com.feint.ariticle_manager.mapper.ArticleMapper
import com.feint.ariticle_manager.mapper.CommentMapper
import com.feint.ariticle_manager.pojo.Article
import com.feint.ariticle_manager.pojo.Chk
import com.feint.ariticle_manager.pojo.Comment
import com.feint.ariticle_manager.pojo.CommentManager
import com.feint.ariticle_manager.pojo.response.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.SQLException
import java.util.*
import kotlin.collections.ArrayList

@Service
class CommentService{
    @Autowired
    lateinit var commentMapper:CommentMapper

    @Autowired
    lateinit var articleMapper:ArticleMapper

    fun commentArticle(comment: Comment):Response<Comment?>{
        return try {
            commentMapper.addComment(comment)
            Response<Comment?>(null,Response.SUCCESS)
        }catch (e:SQLException){
            Response<Comment?>(null,Response.ARTICLE_INCORRECT_CHAR)
        }
    }

    fun commentComment(comment: Comment){
        commentMapper.addComment(comment)
    }

    fun getCommentComment(id:Long):Comment{
        val comment=commentMapper.selectCidById(id)
        return commentMapper.selectCidById(comment.cid)
    }

    fun getArticleComment(aid:Long)=commentMapper.selectAllCommentByAid(aid)
    //TODO 目前写法不适合进行分页，需要改进
    fun manageComment(uid:Long):List<CommentManager>{
        val mList:MutableList<CommentManager> = ArrayList()
        val aList=articleMapper.findAllArticleByChkAndUid(Chk.CHECKED.chkState,uid)
        aList.forEach {
            val comList=commentMapper.selectAllCommentByAid(it.id)
            comList.forEach { comment->
                mList.add(CommentManager(it.id,it.title,comment.id,comment.content,comment.uid,comment.subdate))
            }
        }

        mList.sortBy { commentManager -> return@sortBy commentManager.subdate }

        return mList
    }
}