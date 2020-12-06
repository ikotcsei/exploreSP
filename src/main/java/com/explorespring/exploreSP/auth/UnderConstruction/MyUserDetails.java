package com.explorespring.exploreSP.auth.UnderConstruction;

import com.explorespring.exploreSP.auth.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class MyUserDetails implements UserDetails {

	private String userName;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;

	public MyUserDetails() {
		super();
	}

	public MyUserDetails(User userName) {

		this.userName = userName.getUserName();
		this.password = userName.getPassword();
		this.active = userName.isEnabled();
//		this.authorities = Arrays.stream(userName.getRoles().split(","))
//				.map(SimpleGrantedAuthority::new)
//				.collect(Collectors.toList());

	}

	// return granted authority instances ?:for the user
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return authorities;
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


}
