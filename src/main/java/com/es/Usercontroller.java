package com.es;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @description:
 * @author: fandp
 * @create: 2020-03-24 14:17
 **/
@RestController
public class Usercontroller {
    @Autowired
    private UserReposiory userReposiory;

    @RequestMapping("/addUser")
    public UserEntity addUser(@RequestBody UserEntity user) {
        return userReposiory.save(user);
    }

    @RequestMapping("/findUser")
    public Optional<UserEntity> findUser(String id) {
        return userReposiory.findById(id);
    }
}
