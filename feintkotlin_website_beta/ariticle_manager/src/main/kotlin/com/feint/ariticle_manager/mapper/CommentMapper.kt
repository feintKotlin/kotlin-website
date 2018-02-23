package com.feint.ariticle_manager.mapper

import com.feint.ariticle_manager.pojo.Comment
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface CommentMapper {
    @Insert("INSERT INTO comment(uid,aid,cid,content) VALUES(#{c.uid},#{c.aid},#{c.cid},#{c.content})")
    fun addComment(@Param("c")comment: Comment)

    @Select("SELECT * FROM comment WHERE aid=#{aid}")
    fun selectAllCommentByAid(@Param("aid")aid:Long):List<Comment>

    @Select("SELECT * FROM comment WHERE cid=#{cid}")
    fun selectAllCommentByCid(@Param("cid")cid:Long):List<Comment>

    @Select("Select * From comment where id=#{id}")
    fun selectCidById(@Param("id")id:Long):Comment
}