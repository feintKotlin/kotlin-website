package com.feint.ariticle_manager.controller

import com.feint.ariticle_manager.pojo.Comment
import com.feint.ariticle_manager.service.CommentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.logging.LogManager

@RestController
class CommentController {
    @Autowired
    lateinit var commentService:CommentService

    @PostMapping("/article/comment/article")
    fun commentArticle(@RequestBody comment: Comment)=commentService.commentArticle(comment)

    @PostMapping("/article/comment/comment")
    fun commentComment(@RequestBody comment: Comment)=commentService.commentComment(comment)

    @GetMapping("/article/comment/article/{aid}")
    fun getArticleComment(@PathVariable("aid")aid:Long)=commentService.getArticleComment(aid)

    @GetMapping("/article/comment/comment/{cid}")
    fun getCommentComment(@PathVariable("cid")cid:Long)=commentService.getCommentComment(cid)

    @GetMapping("/article/comment/manager/{uid}")
    fun manageComment(@PathVariable("uid")uid:Long)=commentService.manageComment(uid)
}