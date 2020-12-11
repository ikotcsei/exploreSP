package com.explorespring.exploreSP;

import com.explorespring.exploreSP.auth.JDBCPostgresql.MyUserDetailsService;
import com.explorespring.exploreSP.model.UserRepository;
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

		System.out.println(userRepository.findByUserName("sanyi").toString());
		System.out.println(userRepository.findById(2).toString());

//		System.out.println(userRepository.findByCustom("s").toArray().toString());

	}



}
