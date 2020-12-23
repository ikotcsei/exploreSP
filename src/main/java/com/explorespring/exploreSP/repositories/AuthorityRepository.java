package com.explorespring.exploreSP.repositories;

import com.explorespring.exploreSP.model.Authority;
import com.explorespring.exploreSP.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/* @RepositoryRestResource  - use to  this to customize export mapping and rels.
    ? https://www.baeldung.com/spring-data-rest-intro
* */


@Repository
public interface AuthorityRepository extends CrudRepository<Authority, String> {
    Optional<Authority> findByUserName(String name);
    Optional<Authority> findByAuthority(String name);

}
