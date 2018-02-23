package com.feint.email_manager.utility

import com.feint.email_manager.pojo.User
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.scheduling.annotation.Async
import javax.mail.MessagingException

open class EmailUtils {
    val logger = LoggerFactory.getLogger(EmailUtils::class.java)

    @Autowired
    lateinit var mailSender: JavaMailSender

    open fun sendValidateEmail(user: User, from: String, token: String) {
        val mailMessage = mailSender.createMimeMessage()
        val messageHelper = MimeMessageHelper(mailMessage, true, "utf-8")
        messageHelper.setFrom(from)
        messageHelper.setTo(user.email)
        messageHelper.setSubject(EMAIL_SUB)
        messageHelper.setText(buildEmailText(user,token),true)

        try {
            mailSender.send(mailMessage)
        } catch (e: MessagingException) {
            logger.info(e.toString())
        }
    }

    companion object {
        val EMAIL_SUB = "FeintKotlin注册认证"
        fun buildEmailText(user: User, token: String): String {
            val url="http://localhost:8687/email/validate/${token}"
            return """
                <html>
                    <head>
                        <style>
                            #fin-reg{
                                display: inline-block;
                                padding: 8px;
                                background-color: #3b4348;
                                color: white;
                                text-decoration-line: none;
                                border-radius:  5px;
                            }
                        </style>
                    </head>
                    <body>

                        <h3>尊敬的用户：${user.nickname}先生</h2>
                        <p>
                            您的邮箱验证码为：<strong>${token}</strong>
                        </p>
                        <p>
                            请将该验证码复制到邮箱验证界面，完成邮箱验证操作。
                        </p>
                        <p>
                            经过邮箱验证后，本站将会不定期的像你推送关于Kotlin的精品内容！
                        </p>
                    </body>
                </html>
            """
        }
    }

}