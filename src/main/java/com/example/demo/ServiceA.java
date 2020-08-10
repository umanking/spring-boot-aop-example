package com.example.demo;

import com.example.demo.aspect.annotation.LogExecutionTime;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * @author Geonguk Han
 * @since 2020-08-10
 */
@Service
public class ServiceA {

    @LogExecutionTime
    public void doSomething() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("call service A & thread sleep, it's boring");
        }
    }

    @LogExecutionTime
    public String method() {
        System.out.println("call method !!!!!");
        return "hello world";
    }

    public void methodWithThrow() {
        throw new IllegalArgumentException("something wrong ");
    }
}
