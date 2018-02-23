package com.feint.ariticle_manager.controller

import com.feint.ariticle_manager.mapper.TypeMapper
import com.feint.ariticle_manager.pojo.ArticleType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TypeController{
    @Autowired
    lateinit var typeMapper:TypeMapper

    @GetMapping("/article/type/all")
    fun allType():List<ArticleType> =typeMapper.findAllTypes()

}
