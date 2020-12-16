package com.explorespring.exploreSP.services;

import com.explorespring.exploreSP.model.Authority;
import com.explorespring.exploreSP.model.User;

import java.util.Set;

public interface AuthorityService {
    Set<Authority> getAuthorities();
}
