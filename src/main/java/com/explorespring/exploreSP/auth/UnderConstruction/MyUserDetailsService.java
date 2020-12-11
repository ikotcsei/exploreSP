package com.explorespring.exploreSP.auth.UnderConstruction;

import com.explorespring.exploreSP.auth.model.User;
import com.explorespring.exploreSP.auth.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/* The userdetailsservice return UserDetails object that contains user information
	for authentication

	UserDetailsService
		gets user data from datasource (db, file, hardcoded, etc), returns as a UserDetails obj.

	UserDetails
	 https://docs.spring.io/spring-security/site/docs/3.0.x/apidocs/org/springframework/security/core/userdetails/UserDetails.html
*
* */


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	//get user details obj via username
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		//optional may not have a value, get user object via UserRepository
		Optional<User> user = userRepository.findByUserName(userName);

		//throwing an exception if user is empty
		user.orElseThrow(() -> new UsernameNotFoundException("Not found : " + userName));

		//return the UserDetails object created by user object
		// map(function) - maps the function to the object,
		// get()  returns the "wrapped" value
		//MyUserDetails::new - create a new MyUserDetails obj.
		return user
				.map(MyUserDetails::new)
				.get();
	}

	//for testing
	public UserRepository getUserRepository(){
		return this.userRepository;
	}

}
