package com.feint.ariticle_manager.service

import com.feint.ariticle_manager.mapper.TagMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TagService {
    @Autowired
    lateinit var tagMapper:TagMapper

    fun getTopTags()=tagMapper.selectTagPageAndOrderByTimes(0,20)
}