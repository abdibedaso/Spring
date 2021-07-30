package com.geekcolab.development.bank.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class TimerAspect {

    /*b) Use the Spring StopWatch functionality to measure the duration of all service level
    methods (any method in the bank.service package) and output the results to the console. */
    @Around("execution(* cs544.exercise13_2.bank.service.*.*(..))")
    public Object invoke(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();

        long totalTime = sw.getLastTaskTimeMillis();
        System.out.println();
        System.out.println("Time to execute " + call.getSignature().getName() + " method of "+ call.getTarget().getClass().getSimpleName() + "class is " + totalTime + " millis");
        System.out.println();

        return retVal;
    }
}
