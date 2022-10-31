package com.bewize.testtechnique.service;

import com.bewize.testtechnique.person.repository.PersonRepository;
import com.bewize.testtechnique.person.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp()
    {
        this.personService
                = new PersonService(this.personRepository);
    }

    @Test
    public void returnsPersons() {
        Pageable pageable = PageRequest.of(0, 10);
        personService.getPersons(pageable);

        verify(personRepository.findAll(pageable));
    }

}
