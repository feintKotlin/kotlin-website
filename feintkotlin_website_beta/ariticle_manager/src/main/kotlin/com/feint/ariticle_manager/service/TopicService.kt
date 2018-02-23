package com.feint.ariticle_manager.service

import com.feint.ariticle_manager.mapper.TopicMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TopicService {

    @Autowired
    lateinit var topicMapper:TopicMapper

    fun getAllTopic(type:Byte)=topicMapper.selectAllTopicByType(type)
}