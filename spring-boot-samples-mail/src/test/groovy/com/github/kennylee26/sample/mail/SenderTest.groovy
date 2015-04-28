package com.github.kennylee26.sample.mail

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import javax.annotation.Resource

/**
 * <p> 发邮件测试 </p>
 * <p>Created on 28/4/15.</p>
 * @author kennylee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MailApplication.class)
class SenderTest {

    @Resource
    private Sender sender

    @Test
    public final void testSendMail() {
        String mailTo = 'test@qq.com'
        String username = 'kenny'
        sender.sendMail(mailTo, username)
    }
}
