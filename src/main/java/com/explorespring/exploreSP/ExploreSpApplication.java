package com.explorespring.exploreSP;

import com.explorespring.exploreSP.auth.JDBCPostgresql.MyUserDetailsService;
import com.explorespring.exploreSP.model.User;
import com.explorespring.exploreSP.repositories.UserRepository;
import com.explorespring.exploreSP.services.AuthorityService;
import com.explorespring.exploreSP.services.AuthorityServiceImpl;
import com.explorespring.exploreSP.services.UserService;
import com.explorespring.exploreSP.services.UserServiceImpl;
import com.explorespring.exploreSP.utility.EmailGenerator;
import com.explorespring.exploreSP.utility.NameGenerator;
import com.mifmif.common.regex.Generex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.regex.Pattern;

// == @springbootconfiguration, @componentscan, @enableautoconfiguration
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ExploreSpApplication {
												//ExlploreSpApplication.class - configuration class, bootstrap create the application context
	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(ExploreSpApplication.class, args);
		MyUserDetailsService myuds = ctx.getBean("myUserDetailsService", MyUserDetailsService.class);

		UserRepository userRepository = myuds.getUserRepository();
		UserServiceImpl userService = ctx.getBean(UserServiceImpl.class);
		AuthorityServiceImpl authorityService =  ctx.getBean(AuthorityServiceImpl.class);


		System.out.println(userRepository.findByUserName("sanyi").toString());
		System.out.println(userRepository.findById(2).toString());

// 		INIT THE TABLES with data
//		userService.saveUser("asdf","asdf",true);+
//		fillTableWithData(userService);

//		System.out.println(userRepository.findAll().toString());

//		System.out.println(userService.countUsers());
//		userService.deleteById(15);
//		System.out.println(userService.countUsers());
//		userService.delete(userService.findById(5).orElse(null));
//		System.out.println(userService.countUsers());

		System.out.println(authorityService.getAuthorities());







		System.out.println("-----------------------------------------------");
	}

	public static void testRandomGeneratorFail(){

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

	}

	public static void fillTableWithData(UserServiceImpl userService){
		EmailGenerator eGen = new EmailGenerator("[a-z]{1,5}[@]{1}[a-z]{1,5}[.]{1}[c][o][m]",5,20);
		NameGenerator nGen = new NameGenerator("[A-Z][a-z]{3,8}[ ]{1}[A-Z][a-z]{3,8}",5,20);
		NameGenerator firstNameGen = new NameGenerator("[A-Z][a-z]{3,8}");

		for(int i=0;i<100;i++){
			userService.saveUser(nGen.getRandomName(),firstNameGen.getRandomName(),true
						,firstNameGen.getRandomName(),firstNameGen.getRandomName(),eGen.getRandomEmail());
		}
	}


	public static void regexTest(){

		String email = "[a-z]{5}[@]{1}[a-z]{5}[.]{1}[c][o][m]";
		Generex generex = new Generex(email);
		//generate 0..10 length
		//String str = generex.random(0,10);
		String str = generex.random(2,10);
		for(int i =0;i < 100; i++){
			System.out.println(str);
			str = generex.random(2,10);
		}

		EmailGenerator eGen = new EmailGenerator("[a-z]{1,5}[@]{1}[a-z]{1,5}[.]{1}[c][o][m]",5,20);
		for(int i=0;i<10;i++){
			System.out.println(eGen.getRandomEmail());
		}

		NameGenerator nGen = new NameGenerator("[A-Z][a-z]{3,8}[ ]{1}[A-Z][a-z]{3,8}",5,20);
		for(int i=0;i<10;i++){
			System.out.println(nGen.getRandomName());
		}

	}


}
