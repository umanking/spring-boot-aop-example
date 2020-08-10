package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author Geonguk Han
 * @since 2020-08-10
 */
@Component
public class Runner implements ApplicationRunner {

    @Autowired
    ServiceA serviceA;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        serviceA.doSomething();
        serviceA.method();
//        serviceA.methodWithThrow();

    }
}
