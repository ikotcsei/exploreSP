package com.explorespring.exploreSP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// == springbootconfiguration, componentscan, enableautoconfiguration
@SpringBootApplication
public class ExploreSpApplication {
												//ExlploreSpApplication.class - configuration class, bootstrap create the application context
	public static void main(String[] args) {
		SpringApplication.run(ExploreSpApplication.class, args);
	}

}
