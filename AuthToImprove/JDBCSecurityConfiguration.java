package org.springframework.samples.petclinic.JDBCauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class JDBCSecurityConfiguration extends WebSecurityConfigurerAdapter {

	// spring autoconfigure the datasource, configured in application.properties
	// @Autowired
	// DataSource dataSource;
	@Autowired
	UserDetailsService uds;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// default user schema, without configuration
		// https://docs.spring.io/spring-security/site/docs/4.0.x/reference/html/appendix-schema.html

		// configure via UserDetailsService
		auth.userDetailsService(uds);

		// configure via jdbc
		// auth.jdbcAuthentication()
		// .dataSource(dataSource)
		// .withDefaultSchema()
		// .withUser( //populate a user to the schema
		// User.withUsername("user")
		// .password("user")
		// .roles("USER")
		// )
		// .withUser(
		// User.withUsername("admin")
		// .password("pass")
		// .roles("ADMIN")
		//
		// );

		// overwrite the default table queries getting user names and authorities
		// .userByUsernameQuery("select username,password,enabled from ....")
		// .authoritiesByUsernameQuery("select username,authority from ...")

	}

	// no passwordencoding
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").antMatchers("/user").hasAnyRole("USER",
		// "ADMIN")
		// .antMatchers("/**").permitAll().and().formLogin();

		http.authorizeRequests().antMatchers("/**").permitAll().and().formLogin();

	}

}
