package com.example;

import com.example.manytoone.Edificio;
import com.example.manytoone.EdificioRepository;
import com.example.manytoone.Vecinos;
import com.example.manytoone.VecinosRepository;
import com.example.onetomany.Cars;
import com.example.onetomany.CarsRepository;
import com.example.onetomany.Company;
import com.example.onetomany.CompanyRepository;
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

		CompanyRepository companyRepository = context.getBean(CompanyRepository.class);
		CarsRepository carsRepository = context.getBean(CarsRepository.class);
		/*var companyRepo = context.getBean(Company.class);
		var carsRepo = context.getBean(Cars.class);*/

		var car1 = new Cars("mod1",4,200);
		var car2 = new Cars("mod2",5,150);
		carsRepository.saveAll(List.of(car1, car2));

		Company comp1 = new Company("nam1","cif1", (List<Cars>) car1);
		companyRepository.save(comp1);
	}
	private static void manyToOne (){
		/*EdificioRepository edificioRepository = context.getBean(EdificioRepository.class);
		VecinosRepository vecinosRepository = context.getBean(VecinosRepository.class);

		Edificio edificio1 = new Edificio("Edificio1",34,"Portero1");

		edificioRepository.saveAll(List.of(edificio1));

		var vec1 = new Vecinos("name1",6,"A","nif1",LocalDate(List.of(2001, Month.NOVEMBER,12)),edificio1);

		vecinosRepository.saveAll(List.of(vec1));*/
	}
	private static void manyToMany (){

	}

}
