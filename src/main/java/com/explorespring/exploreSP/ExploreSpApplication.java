package com.explorespring.exploreSP;

import com.explorespring.exploreSP.auth.JDBCPostgresql.MyUserDetailsService;
import com.explorespring.exploreSP.model.User;
import com.explorespring.exploreSP.repositories.UserRepository;
import com.explorespring.exploreSP.services.UserService;
import com.explorespring.exploreSP.services.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// == springbootconfiguration, componentscan, enableautoconfiguration
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ExploreSpApplication {
												//ExlploreSpApplication.class - configuration class, bootstrap create the application context
	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(ExploreSpApplication.class, args);
		MyUserDetailsService myuds = ctx.getBean("myUserDetailsService", MyUserDetailsService.class);

		UserRepository userRepository = myuds.getUserRepository();
		UserServiceImpl userService = ctx.getBean(UserServiceImpl.class);

		System.out.println(userRepository.findByUserName("sanyi").toString());
		System.out.println(userRepository.findById(2).toString());


		userService.saveUser("asdf","asdf",true);

		System.out.println(userRepository.findAll().toString());

//		System.out.println(userRepository.findByCustom("s").toArray().toString());

	}



}
