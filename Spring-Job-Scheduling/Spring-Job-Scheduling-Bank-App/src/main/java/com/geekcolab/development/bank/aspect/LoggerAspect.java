package com.geekcolab.development.bank.aspect;

import com.geekcolab.development.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggerAspect {

    ILogger logger;

    /*a) Log every call to any method in the bank.dao package (using the Logger). */
    @Before("execution(* com.geekcolab.development.bank.dao.*.*(..))")
    public void logEmailEvent(JoinPoint joinPoint) {
        logger.log("Call to " + joinPoint.getSignature().getName() + "method of " + joinPoint.getTarget().getClass().getSimpleName() + "class");
        System.out.println("Call to " + joinPoint.getSignature().getName() + "method of " + joinPoint.getTarget().getClass().getSimpleName() + "class" + "is Logged!");
    }

    @After("execution(public void com.geekcolab.development.bank.jms.JMSSender.sendJMSMessage(String)) && args(message)")
    public void logEmailEvent(JoinPoint joinPoint, String message) {

        /*b) c) Log every JMS message that is sent (using the Logger) */
        logger.log("message is logged: " + message);
        System.out.println("message = " + message);

    }

    public void setLogger(ILogger logger) {
        this.logger = logger;
    }
}
