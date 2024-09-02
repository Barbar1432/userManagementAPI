package com.barbar.usermanagementapi.service;
import com.barbar.usermanagementapi.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    List<User> findAllUsers();
    Optional<User> findUserById(Long id);
    void deleteUserById(Long id);
}
