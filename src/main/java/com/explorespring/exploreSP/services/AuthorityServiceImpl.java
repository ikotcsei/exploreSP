package com.explorespring.exploreSP.services;

import com.explorespring.exploreSP.model.Authority;
import com.explorespring.exploreSP.model.User;
import com.explorespring.exploreSP.repositories.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

@Service
public class AuthorityServiceImpl implements AuthorityService{

    private final AuthorityRepository authorityRepository;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public Set<Authority> getAuthorities() {

        TreeSet<Authority> authTreeSet = new TreeSet<>();

        authorityRepository.findAll().iterator().forEachRemaining(authTreeSet::add);

//        Iterator<Authority> it = authTreeSet.iterator();
//        Authority curr = new Authority();
//        while(it.hasNext()){
//            curr = it.next();
//            System.out.println(curr.getUserName() +"  "+ curr.getAuthority() + "\n");
//        }

        return  authTreeSet;
    }
}
