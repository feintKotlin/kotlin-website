package com.feint.file_manager.controller

import com.feint.file_manager.service.ImageService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
class ImageController{
    val logger=LoggerFactory.getLogger(ImageController::class.java)
    @Autowired
    lateinit var imageService:ImageService


    @GetMapping("/images/{imgName}")
    fun image(@PathVariable("imgName")imgName:String)=
            imageService.image(imgName)

    @GetMapping("/images/protrait/all")
    fun allProtrait()=imageService.getAllProtrait()

    @PostMapping("/images/upload")
    fun uploadImage(@RequestParam("image") multiPart:MultipartFile)=imageService.saveImage(multiPart)


}