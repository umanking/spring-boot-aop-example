package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Geonguk Han
 * @since 2020-08-10
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
