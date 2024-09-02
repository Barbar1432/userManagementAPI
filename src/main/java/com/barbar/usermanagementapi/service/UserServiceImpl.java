package com.barbar.usermanagementapi.service;
import com.barbar.usermanagementapi.model.User;
import com.barbar.usermanagementapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser (User user){
        return userRepository.save(user);
    }
    @Override
    public List<User> findAllUsers() { return userRepository.findAll(); }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }
}
