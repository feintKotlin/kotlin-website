package com.feint.file_manager.service

import com.feint.file_manager.mapper.ProtraitMapper
import com.feint.file_manager.mapper.ResPathMapper
import com.feint.file_manager.pojo.response.Response
import com.feint.file_manager.utility.FileUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.InputStreamResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream

@Service
class ImageService {

    @Autowired
    lateinit var protraitMapper:ProtraitMapper

    @Autowired
    lateinit var resPathMapper:ResPathMapper

    fun image(imgName:String): ResponseEntity<InputStreamResource>? {
        val file= FileSystemResource(getPath(imgName));
        val headers= HttpHeaders();
        headers.add("Cache-Control","no-cache,no-store,must-revalidate");
        headers.add("Content-Disposition","attachment; filename=xxxx");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
        .body(InputStreamResource(file.getInputStream()))
    }

    fun getPath(filename:String):String{
        resPathMapper.findAllPath().forEach {
            if(File("$it/$filename.png").exists()) return "$it/$filename.png"
        }
        return ""
    }

    fun getAllProtrait()=protraitMapper.findAllProtrait()

    fun saveImage(multiFile:MultipartFile):Response<String>{
        val filemd5="${FileUtils.md5(multiFile.inputStream)}"
        val filename="$filemd5.png"
        val path="/root/feintkotlin/images/$filename"
        val file=File(path)
        if(!file.exists()){
            FileOutputStream(file).write(multiFile.bytes)
        }
        return Response<String>(filemd5,Response.SUCCESS)
    }
}