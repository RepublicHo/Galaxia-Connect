package com.g31.demo.repository;


import com.g31.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @Description: via用户名username or password查找用户，注意要按照JPA的格式使用camel case
 *
 * if we want more features, more could be added.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String username);
    User findByUserNameAndPassword(String username, String password);
    User findUserByUid(long uid);
    Optional<User> findByEmail(String email);
    void deleteByUserName(String username);
}