package com.explorespring.exploreSP;

import com.explorespring.exploreSP.auth.JDBCPostgresql.MyUserDetailsService;
import com.explorespring.exploreSP.model.User;
import com.explorespring.exploreSP.repositories.UserRepository;
import com.explorespring.exploreSP.services.UserService;
import com.explorespring.exploreSP.services.UserServiceImpl;
import com.mifmif.common.regex.Generex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.regex.Pattern;

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

		String email = "[a-z]{5}[@]{1}[a-z]{5}[.]{1}[c][o][m]";
		String errorReg = "]";
		Generex generex = new Generex(errorReg);
		//generate 0..10 length
		//String str = generex.random(0,10);
		String str = generex.random(2,10);
		for(int i =0;i < 100; i++){
			System.out.println(str);
			str = generex.random(2,10);
		}

		try {
			byte[] array = new byte[7]; // length is bounded by 7
			new Random().nextBytes(array);
			String generatedString = new String(array, Charset.forName("UTF-8"));

			while(true){
				System.out.println(Pattern.compile(generatedString));
				new Random().nextBytes(array);
				generatedString = new String(array, Charset.forName("UTF-8"));
			}


		}
		catch(Exception exep){
				System.out.println(exep.toString());
		}

	//random name, email, pwd, stb

//		System.out.println(userRepository.findByCustom("s").toArray().toString());

	}



}
