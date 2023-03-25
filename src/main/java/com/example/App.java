package com.example;

import com.example.onetoone.Address;
import com.example.onetoone.AddressRepository;
import com.example.onetoone.User;
import com.example.onetoone.UserRepository;
import org.hibernate.mapping.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication

public class App {

	static ApplicationContext context;
	public static void main(String[] args) {
		context = SpringApplication.run(App.class, args);
		oneToOne ();
		oneToMany();
		manyToOne();
		manyToMany();
	}
	private static void oneToOne () {
		var userRepo = context.getBean(UserRepository.class);
		var addressRepo = context.getBean(AddressRepository.class);

		Address add1 = new Address("calle1","local1","city1","pais1",28000);
		Address add2 = new Address("calle2","local2","city2","pais2",28100);
		addressRepo.save(add1);
		addressRepo.save(add2);

		User user1= new User("user1","email1","nif1",add1);
		User user2= new User("user2","email2","nif2",add2);
		userRepo.save(user1);
		userRepo.save(user2);

	}
	private static void  oneToMany (){

	}
	private static void manyToOne (){

	}
	private static void manyToMany (){

	}

}
