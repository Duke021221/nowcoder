package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testMail {

    @Autowired
    private MailClient mailClient;

    @Test
    public void testSendMail(){
        mailClient.sendMail("3342242688@qq.com","test","Hello World");
    }
}
