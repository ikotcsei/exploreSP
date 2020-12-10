package com.explorespring.exploreSP.auth.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
                                            // JpaRepository<return type, id-type>
public interface UserRepository extends JpaRepository<User, Integer> {
    //automatic method generated findById, findBy.... (User object field vars)
    Optional<User> findByUserName(String userName);

}
