package com.explorespring.exploreSP.services;

import com.explorespring.exploreSP.model.User;
import com.explorespring.exploreSP.repositories.UserRepository;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> getUser() {
        Set<User> userSet = new HashSet<>();
        userRepository.findAll().iterator().forEachRemaining(userSet::add);
        return userSet;
    }

    public void saveUser(String name, String pass, boolean isEnabled){

        User tmpU = new User(name,pass,isEnabled);
        userRepository.save(tmpU);
    }

}
