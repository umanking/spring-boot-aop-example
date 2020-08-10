package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Geonguk Han
 * @since 2020-08-10
 */
@Component
@Aspect
@Slf4j
public class TransactionAspect {


    @Around("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void transactional(ProceedingJoinPoint joinPoint) throws Throwable {
        final Object[] args = joinPoint.getArgs();

        log.info(" 저장 전  parameter : " + Arrays.toString(args));

        final Object proceed = joinPoint.proceed();

        log.info("결과값: " + proceed);
    }

}
