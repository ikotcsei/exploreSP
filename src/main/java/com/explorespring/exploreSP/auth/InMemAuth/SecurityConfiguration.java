package com.explorespring.exploreSP.auth.InMemAuth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*auth interface
	https://docs.spring.io/spring-security/site/docs/4.2.19.RELEASE/apidocs/org/springframework/security/core/Authentication.html
*
	AuthenticationManager  <---> Authentication provider(methods : supports(), ) : pwd, oauth, LDAP , etc.  <---> UserDetailService
																											(param : username, ret: user object with details)
	providermanager implements authentication manager
	interface UserDetails

	authentication :
		in memory(basic setup)
		sql  : h2 embedded, mysql, ...
		ldap
		oauth
		jwt
* */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder authM) throws Exception {

		// basic memory AUTHENTICATION hardcoded here
		authM.inMemoryAuthentication().withUser("inmemuser").password("inmemuser").roles("USER").and().withUser("admin")
				.password("admin").roles("ADMIN");

		// via datasource : authM.jdbcAuthentication()....
		// via ldap : authM.ldapAuthentication()...
		// via JPA : authM.userDetailsService(uds);
		//via memory : authM.inMemoryAuthentication()...

	}

	// no password encoding
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// standard login , start with most restrictive !
		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").antMatchers("/user")
				.hasAnyRole("USER", "ADMIN").antMatchers("/h2-console").permitAll().antMatchers("/**").permitAll().and()
				.formLogin();

		// make h2-console work
		http.csrf().disable();
		http.headers().frameOptions().disable();

		// http.authorizeRequests().antMatchers("/").permitAll() // root enabled all
		// levels
		// .antMatchers("/**").hasRole("ADMIN").and().formLogin(); //amin enabled all urls

		// basic configuratin initalized by spring
		// http.authorizeRequests()
		// .antMatchers("/**").hasAnyRole("")
		// .and().formLogin(); // specify the login method required, user/login application.properties- ben
	}

}
