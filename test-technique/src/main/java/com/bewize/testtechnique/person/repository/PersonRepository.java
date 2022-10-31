package com.bewize.testtechnique.person.repository;

import com.bewize.testtechnique.person.model.Person;
import com.bewize.testtechnique.person.model.PersonsSex;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

    import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByFirstName(String firstName, Pageable pageable);
    List<Person> findAllByLastName(String lastName, Pageable pageable);
    Page<Person> findAll(Pageable pageable);

    @Query("SELECT p FROM person p WHERE p.sex = :personsSex")
    List<Person> findAllBySex(PersonsSex personsSex, Pageable pageable);

    // @Query("SELECT p FROM person p WHERE EXTRACT (YEAR FROM p.birthDate) > :year")
    // List<Person> filterAllOlderThanAge(int year, Pageable pageable);

    // @Query("SELECT p FROM person p WHERE EXTRACT(YEAR FROM p.date) < :year")
    // List<Person> filterAllYoungerThanAge(int year, Pageable pageable);

}
