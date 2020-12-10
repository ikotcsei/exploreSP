package com.explorespring.exploreSP;

import com.explorespring.exploreSP.auth.model.User;
import com.explorespring.exploreSP.auth.model.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

// == springbootconfiguration, componentscan, enableautoconfiguration
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ExploreSpApplication {
												//ExlploreSpApplication.class - configuration class, bootstrap create the application context
	public static void main(String[] args) {
		SpringApplication.run(ExploreSpApplication.class, args);
	}

//	UserRepository ur = new UserRepository() {
//		@Override
//		public Optional<User> findByUserName(String userName) {
//			return Optional.empty();
//		}
//	};

}
