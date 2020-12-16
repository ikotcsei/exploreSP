package com.explorespring.exploreSP.repositories;

import com.explorespring.exploreSP.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*extends Repository, CrudRepository, JpaRepository
*
* */

@Repository                             // JpaRepository<return type, id-type>
public interface UserRepository extends CrudRepository<User, Integer> {
    //automatic method generated findById, findBy.... (User object field vars)
    Optional<User> findByUserName(String userName);

    Optional<User> findByFirstName(String userName);

    Optional<User> findByLastName(String userName);

    Optional<User> findById(@Param("id") Integer id);


    // @Query : https://www.baeldung.com/spring-data-jpa-query
    //@Transactional : https://dzone.com/articles/how-does-spring-transactional
//    @Query(value = "SELECT user FROM users WHERE users.username LIKE :lastName% ", nativeQuery = true)
////    @Query(value = "SELECT user FROM users WHERE users.username LIKE :lastName% ")
//    @Transactional(readOnly = true)
//    Collection<User> findByCustom(@Param("lastName") String lastName);

}
