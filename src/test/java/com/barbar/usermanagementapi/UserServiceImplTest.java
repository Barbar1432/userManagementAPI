package com.barbar.usermanagementapi;
import com.barbar.usermanagementapi.model.User;
import com.barbar.usermanagementapi.repository.UserRepository;
import com.barbar.usermanagementapi.service.UserServiceImpl;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;
    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
        User user1 = new User( "Messi", "messi@example.com", "goat", "user");
        User user2 = new User( "Ronaldo", "ronaldo@example.com", "goat", "admin");
        userRepository.save(user1);
        userRepository.save(user2);
    }

    @Test
    void testSaveUser() {
        User user = new User( "Lebron", "lebron@example.com", "goat", "user");
        User savedUser = userService.saveUser(user);

        assertNotNull(savedUser.getId());
        assertEquals("Lebron", savedUser.getUsername());
    }

    @Test
    void testFindAllUsers() {
        List<User> users = userService.findAllUsers();
        assertEquals(2, users.size());
    }
    @Test
    void testFindUserById() {
        User savedUser = userRepository.save(new User("Messi", "messi@example.com", "goat", "user"));
        Optional<User> user = userService.findUserById(savedUser.getId());
        assertTrue(user.isPresent());
        assertEquals("Messi", user.get().getUsername());
    }

}
