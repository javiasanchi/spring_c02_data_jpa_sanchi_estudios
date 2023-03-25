package com.example;

import com.example.manytoone.Edificio;
import com.example.manytoone.EdificioRepository;
import com.example.manytoone.Vecinos;
import com.example.manytoone.VecinosRepository;
import com.example.onetoone.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

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

		addressRepo.saveAll(List.of(add1,add2));


		User user1= new User("user1","email1","nif1", UserType.BRONZE,add1);
		User user2= new User("user2","email2","nif2",UserType.GOLD,add2);

		userRepo.saveAll(List.of(user1,user2));


	}
	private static void  oneToMany (){

	}
	private static void manyToOne (){
		EdificioRepository edificioRepository = context.getBean(EdificioRepository.class);
		VecinosRepository vecinosRepository = context.getBean(VecinosRepository.class);

		var vecino1 = new Vecinos("vec1","6","A", LocalDate(2000, Month.APRIL,23),"nif1");
		var vecino2 = new Vecinos("vec2","7","A", LocalDate(19690, Month.NOVEMBER,30),"nif2");
		var vecino3 = new Vecinos("vec3","2","B",LocalDate(1990,Month.JUNE,22),"nif3");

		vecinosRepository.saveAll(List.of(vecino1,vecino2,vecino3));

		Edificio edificio1 = new Edificio("Edificio1",34,"Portero1",vecino1);
		Edificio edificio2 = new Edificio("Edificio2",14,"Portero2",vecino2);

		edificioRepository.saveAll(List.of(edificio1,edificio2));

	}
	private static void manyToMany (){

	}

}
