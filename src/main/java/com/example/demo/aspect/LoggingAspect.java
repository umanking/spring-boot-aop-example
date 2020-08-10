package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Geonguk Han
 * @since 2020-08-10
 */
@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Around("@annotation(com.example.demo.aspect.annotation.LogExecutionTime)")
    public void printLoggingTime(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("kind : " + joinPoint.getKind());
        System.out.println("args : " + joinPoint.getArgs());
        System.out.println("signature : " + joinPoint.getSignature());

        // startTime
        long startTime = System.currentTimeMillis();

        final String proceed = (String) joinPoint.proceed();
        System.out.println("return proceed : " + proceed);


        // endTime and calculate total time
        long time = System.currentTimeMillis() - startTime;
        log.info("time : " + time / 1000  + "sec");
    }

    @Before("execution(* com.example.demo.ServiceA.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("before method : " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.demo.ServiceA.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        System.out.println("after method : " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.example.demo.ServiceA.*(..))")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("after returning method : " + joinPoint.getSignature().getName());
    }


    @AfterThrowing(value = "execution(* com.example.demo.ServiceA.*(..))", throwing = "ex")
    public void afterMethodWithThrow(IllegalArgumentException ex) {
        System.out.println("after method with throw : " + ex.getMessage());

    }






}
