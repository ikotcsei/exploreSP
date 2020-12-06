package com.explorespring.exploreSP.auth.UnderConstruction;

import com.explorespring.exploreSP.auth.model.User;
import com.explorespring.exploreSP.auth.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		//optional may not have a value
		Optional<User> user = userRepository.findByUserName(userName);

		//throwing an exception if user is empty
		user.orElseThrow(() -> new UsernameNotFoundException("Not found : " + userName));
		return user.map(MyUserDetails::new).get();
	}

}
