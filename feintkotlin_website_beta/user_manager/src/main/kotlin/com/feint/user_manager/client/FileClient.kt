package com.feint.user_manager.client

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping

@FeignClient("file-manager")
interface FileClient {

    @RequestMapping("/images/protrait/all")
    fun allProtrait():List<String>
}
