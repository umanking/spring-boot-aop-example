package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Geonguk Han
 * @since 2020-08-10
 */

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findOne(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalStateException());
    }

    @Transactional
    public void updateUser(Long id, User user) {
        final User existUser = findOne(id);
        existUser.setName(user.getName());
        existUser.setAge(user.getAge());
    }

}
