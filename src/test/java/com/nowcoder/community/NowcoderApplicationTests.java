package com.nowcoder.community;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;



@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class NowcoderApplicationTests implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

//    @Test
//    public void testApplicationContext(){
//        System.out.println(applicationContext);
//        AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
//        System.out.println(alphaDao.Select());
//
//        alphaDao = applicationContext.getBean("alphaHibernate",AlphaDao.class);
//        System.out.println(alphaDao.Select());
//    }
//    @Test
//    public void testBeanManagement(){
//        AlphaService alphaService = applicationContext.getBean(AlphaService.class);
//        System.out.println(alphaService);
//        alphaService = applicationContext.getBean(AlphaService.class);
//        System.out.println(alphaService);
//    }
    @Test
    public void testBeanConfig(){
        SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(simpleDateFormat.format(new Date()));
    }

//    @Autowired
//    @Qualifier("alphaHibernate")
//    private AlphaDao alphaDao;
//
//    @Test
//    public void testDI(){
//        System.out.println(alphaDao.Select());
//    }


}
