package com.bewize.testtechnique;

import com.bewize.testtechnique.person.model.Person;
import com.bewize.testtechnique.person.model.PersonsSex;
import com.bewize.testtechnique.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import java.util.Date;

@SpringBootApplication
public class TestTechniqueApplication implements CommandLineRunner {

	@Autowired
	PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestTechniqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int numberOfInitPersons = 100;
		if(args.length >0){
			numberOfInitPersons = Integer.parseInt(args[0]);
		}
		for(int i=0; i<numberOfInitPersons; i++) {
			int randomValue = (int)(Math.random()*100);
			PersonsSex randomPersonsSex = randomValue%2 == 0 ? PersonsSex.MALE: PersonsSex.FEMALE;
			Date randomDate = new Date(randomValue);
			Person randomPerson = new Person(null, "first-name:"+i, "last-name:"+i, randomPersonsSex, randomDate);
			personRepository.save(randomPerson);
		}
	}
}
