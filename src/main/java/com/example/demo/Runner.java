package com.example.demo;

import com.example.demo.user.User;
import com.example.demo.user.UserService;
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

    @Autowired
    UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        serviceA.doSomething();
//        serviceA.method();
//        serviceA.methodWithThrow();


        final User user = new User();
        user.setName("andrew");
        user.setAge(32);
        userService.saveUser(user);

        final User user1 = userService.findOne(user.getId());

        final User user2 = new User();
        user2.setName("GG han");
        user2.setAge(33);
        userService.updateUser(user.getId(), user2);


    }
}
