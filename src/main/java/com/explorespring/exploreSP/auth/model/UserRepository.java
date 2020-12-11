package com.explorespring.exploreSP.auth.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/*extends Repository, CrudRepository, JpaRepository
*
* */
                                            // JpaRepository<return type, id-type>
public interface UserRepository extends CrudRepository<User, Integer> {
    //automatic method generated findById, findBy.... (User object field vars)
    Optional<User> findByUserName(String userName);


    Optional<User> findById(@Param("id") Integer id);

//    @Query(value = "SELECT user FROM users WHERE users.username LIKE :lastName% ", nativeQuery = true)
////    @Query(value = "SELECT user FROM users WHERE users.username LIKE :lastName% ")
//    @Transactional(readOnly = true)
//    Collection<User> findByCustom(@Param("lastName") String lastName);

}
