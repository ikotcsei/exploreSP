package com.explorespring.exploreSP.services;

import com.explorespring.exploreSP.model.User;
import com.explorespring.exploreSP.repositories.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> getUser() {
//        Set<User> userSet = new HashSet<>();
        TreeSet<User> userTreeSet = new TreeSet<>();

        userRepository.findAll().iterator().forEachRemaining(userTreeSet::add);


//        userTreeSet.addAll(userSet);

        return userTreeSet;
    }

    public void saveUser(String name, String pass, boolean isEnabled,String firstName,String lastName, String email){

        User tmpU = new User(name,pass,isEnabled,firstName,lastName,email);
        userRepository.save(tmpU);
    }

    public long countUsers(){
        return userRepository.count();
    }

    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }

    public void delete(User u){
        userRepository.delete(u);
    }


    public Optional<User> findById(Integer id){
        return userRepository.findById(id);
    }

}
