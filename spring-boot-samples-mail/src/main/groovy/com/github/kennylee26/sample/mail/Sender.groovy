package com.github.kennylee26.sample.mail

import com.google.common.collect.Maps
import org.apache.velocity.app.VelocityEngine
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.javamail.JavaMailSenderImpl
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Component
import org.springframework.ui.velocity.VelocityEngineUtils

import javax.annotation.Resource
import javax.mail.internet.MimeMessage

/**
 * <p> 邮件发送 </p>
 * <p>Created on 28/4/15.</p>
 * @author kennylee
 */
@Component
class Sender {

    private final Logger logger = LoggerFactory.getLogger(getClass())

    private static final String mailTitle = '邮件提醒'
    @Value('${mail.templateName}')
    private String templateName
    @Resource
    private VelocityEngine velocityEngine
    @Resource
    private JavaMailSenderImpl mailSender

    public void sendMail(String mailTo, String username) {
        MimeMessage mimeMessage = mailSender.createMimeMessage()
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage)
        messageHelper.setFrom(mailSender.getUsername())
        messageHelper.setTo(mailTo)
        messageHelper.subject = mailTitle
        Map<String, Object> model = Maps.newHashMap()
        model.put('username', username)
        String context = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateName, mailSender.getDefaultEncoding(), model)
        messageHelper.setText(context, true)
        mailSender.send(messageHelper.getMimeMessage())
    }
}