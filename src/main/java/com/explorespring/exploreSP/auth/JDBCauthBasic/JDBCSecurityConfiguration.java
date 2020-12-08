package com.explorespring.exploreSP.auth.JDBCauthBasic;

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

//creates tables users and authorities, remove sql statements from shcema to work
//or remove schema load from application.properties
@EnableWebSecurity
public class JDBCSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {


		// configure via jdbc
		 auth.jdbcAuthentication()
		 .dataSource(dataSource)
		 .withDefaultSchema()  // use the default spring schema
		 .withUser( //populate a user to the schema
		 User.withUsername("jdbcuser")
		 .password("jdbcuser")
		 .roles("USER")
		 )
		 .withUser(
		 User.withUsername("jdbcadmin")
		 .password("jdbcadmin")
		 .roles("ADMIN")
		 );

		 //NON DEFAULT SPRING SCHEMA
		/*
		  .usersByUsernameQuery(
		  	"Select username,password,enabled from users where username = ?"
		  )
		  .authoritiesByUsernameQuery(
		  	"select username,authority from authorities where username = ?"
		  );
		* */


	}

	// no passwordencoding
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {


		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").antMatchers("/user")
				.hasAnyRole("USER", "ADMIN").antMatchers("/h2-console").permitAll().antMatchers("/**").permitAll().and()
				.formLogin();

		// make h2-console work
		http.csrf().disable();
		http.headers().frameOptions().disable();

	}

}
