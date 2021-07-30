package com.geekcolab.development;

import com.geekcolab.development.service.ApplicationService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        /* Create an ApplicationContext based on 'spring_config.xml' */
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");

        ApplicationService applicationService = context.getBean("applicationService", ApplicationService.class);
        applicationService.sayHello();

    }

}
