package com.example;

import com.example.manytomany.Alumnos;
import com.example.manytomany.AlumnosRepository;
import com.example.manytomany.Materias;
import com.example.manytomany.MateriasRepository;
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

		var car1 = new Cars("mod1",4,200);
		var car2 = new Cars("mod2",5,150);
		var car3 = new Cars("mod3",5,170);
		carsRepository.saveAll(List.of(car1, car2,car3));

		Company comp1 = new Company("nam1","cif1");

		comp1.getCars(car2).add(car2);
		comp1.getCars(car3).add(car3);
		companyRepository.save(comp1);
		Company comp2 = new Company("nam2","cif2");
		comp2.getCars(car1).add(car1);
		companyRepository.save(comp1);
		companyRepository.save(comp2);
	}
	private static void manyToOne (){
		EdificioRepository edificioRepository = context.getBean(EdificioRepository.class);
		VecinosRepository vecinosRepository = context.getBean(VecinosRepository.class);

		Edificio edi1 = new Edificio("edi1",34,"port1");
		edificioRepository.save(edi1);
		var edi2 = new Edificio("nomb2",23,"port2");
		edificioRepository.save(edi2);

		var vec1 = new Vecinos("nom1","nif1",edi1);
		var vec2 = new Vecinos("nom2","nif2",edi1);
		var vec3 = new Vecinos("nom3","nif3",edi1);
		vecinosRepository.saveAll(List.of(vec1,vec2,vec3));
	}
	private static void manyToMany (){
		AlumnosRepository alumnosRepository = context.getBean(AlumnosRepository.class);
		MateriasRepository materiasRepository = context.getBean(MateriasRepository.class);

		var mat1 = new Materias("Física","40");
		var mat2 = new Materias("Química","30");
		var mat3 = new Materias("Biología","35");
		var mat4 = new Materias("Matemáticas","45");
		materiasRepository.saveAll(List.of(mat1,mat2,mat3,mat4));

		var alum1 = new Alumnos("nom1",LocalDate.of(2002,Month.JANUARY,18),"ident1");
		alum1.getMaterias().addAll(List.of(mat1,mat2,mat3,mat4));

		var alum2 = new Alumnos("nom2",LocalDate.of(2003,Month.AUGUST,29),"ident2");
		alum2.getMaterias().addAll(List.of(mat1,mat2,mat4));

		alumnosRepository.saveAll(List.of(alum1, alum2));


	}

}
