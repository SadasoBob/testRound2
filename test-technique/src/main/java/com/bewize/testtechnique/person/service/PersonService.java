package com.bewize.testtechnique.person.service;

import com.bewize.testtechnique.person.model.Person;
import com.bewize.testtechnique.person.model.PersonsSex;
import com.bewize.testtechnique.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Page<Person> getPersons(Pageable pageable){
        return personRepository.findAll(pageable);
    }

    public List<Person> getPersonsByFirstName(String firstName, Pageable pageable) {
        return personRepository.findAllByFirstName(firstName, pageable);
    }

    public List<Person> getPersonsByLastName(String firstName, Pageable pageable) {
        return personRepository.findAllByLastName(firstName, pageable);
    }

    public List<Person> getPersonsBySex(PersonsSex personsSex, Pageable pageable) {
        return personRepository.findAllBySex(personsSex, pageable);
    }

    //public List<Person> getPersonsOlderThanAge(int age, Pageable pageable) {
    //    int birthYear = new Date().getYear()-age;
    //    return personRepository.filterAllOlderThanAge(birthYear, pageable);
    //}

    //public List<Person> getPersonsYoungerThanAge(int age, Pageable pageable) {
    //    int birthYear = new Date().getYear()-age;
    //    return personRepository.filterAllYoungerThanAge(birthYear, pageable);
    //}
}
