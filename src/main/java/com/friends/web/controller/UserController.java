package com.friends.web.controller;

import com.friends.model.User;
import com.friends.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author David Liebl
 */

@Controller
@RequestMapping(value = "users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public User newUser(@RequestParam String username) {
        User user = userRepository.findByUsername(username);

        if (user != null) {
            return user;
        } else {
            user = new User();
        }

        user.setUsername(username);
        return userRepository.save(user);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsersAsJson() {
        return userRepository.findAll();
    }
}
