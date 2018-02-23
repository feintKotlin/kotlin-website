package com.feint.file_manager.service

import com.feint.file_manager.pojo.Article
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.File
import java.nio.charset.Charset

@Service
class PageStaticService {
    val logger = LoggerFactory.getLogger(PageStaticService::class.java)


    val filePath = "/var/www/html/singles"
    fun staticPage(article: Article) {
        val modelString = loadModel()
        val tagString = "\$(\"#article-body\").html(marked(\""
        val tagIndex = modelString.indexOf(tagString)
        var beforeString = modelString.slice(0..tagString.length + tagIndex - 1)
        val afterString = modelString.slice(tagString.length + tagIndex..modelString.length - 1)
        val beforelocal = afterString.slice(0..3)
        val afterlocal = afterString.subSequence(4..afterString.length - 1)


        val file = File("$filePath/${article.id}.html")
        // logger.info(it.title)
        val localString = """
                localStorage.currentArticleId=${article.id}
                localStorage.currentTypeId=${article.type}
                localStorage.currentTopic="${article.topic}"
            """
        file.writeText(beforeString + createOnelineText(article.content) +
                beforelocal + localString + afterlocal)

    }



    fun loadModel(): String {
        val modelFile = File("$filePath/model.html")
        return modelFile.readText(Charset.defaultCharset())
    }

    fun createOnelineText(md: String): String {
        var result = ""
        md.split('\n').forEach {
            result += it.replace("\\", "\\\\").replace("\"", "\\\"") + "\\n"
        }
        return result
    }
}