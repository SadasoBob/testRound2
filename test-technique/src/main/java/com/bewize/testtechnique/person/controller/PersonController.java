package com.bewize.testtechnique.person.controller;

import com.bewize.testtechnique.person.model.Person;
import com.bewize.testtechnique.person.model.PersonsSex;
import com.bewize.testtechnique.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "persons")
    public List<Person> getPersons(@PageableDefault Pageable pageable){
        return personService.getPersons(pageable).stream().toList();
    }

    @GetMapping(value = "persons/firstName")
    public List<Person> getPersonsByFirstName(@RequestParam(value = "first-name") String firstName, @PageableDefault Pageable pageable){
        return personService.getPersonsByFirstName(firstName, pageable);
    }

    @GetMapping(value = "persons/lastName")
    public List<Person> getPersonsByLastName(@RequestParam(value = "last-name") String lastName, @PageableDefault Pageable pageable){
        return personService.getPersonsByLastName(lastName, pageable);
    }

    @GetMapping(value = "persons/sex")
    public List<Person> getPersonsBySex(@RequestParam(value = "sex") String sex, @PageableDefault Pageable pageable){
        PersonsSex personsSex = (sex.equals("male") || sex.equals("MALE")) ? PersonsSex.MALE: PersonsSex.FEMALE;
        return personService.getPersonsBySex(personsSex, pageable);
    }

    //@GetMapping(value = "persons/age")
    //public List<Person> getPersonsOlderThanAge(@RequestParam(value = "older") int age, @PageableDefault Pageable pageable){
    //    return personService.getPersonsOlderThanAge(age, pageable);
    //}

    //@GetMapping(value = "persons/age")
    //public List<Person> getPersonsYoungerThanAge(@RequestParam(value = "younger") int age, @PageableDefault Pageable pageable){
    //    return personService.getPersonsYoungerThanAge(age, pageable);
    //}

}
