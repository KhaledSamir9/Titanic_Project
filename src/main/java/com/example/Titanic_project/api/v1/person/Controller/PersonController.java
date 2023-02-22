package com.example.Titanic_project.api.v1.person.Controller;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Titanic_project.Database.Entities.Person;
import com.example.Titanic_project.Service.PersonService;
import com.example.Titanic_project.api.v1.person.Dto.PersonDto;

@RestController
public class PersonController {

    Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personservice;

    @GetMapping("/people")
    public List<Person> getAllPersons() throws Exception {
        List<Person> people = null;
        try {
            logger.info("getPeople started");

            people = personservice.getAllPersons();
            if (people != null) {

                logger.info("getPeople completed");

                return people;
            } else {
                logger.info("getPeople NULL.............");
                return people;
            }
        } catch (Exception e) {
            logException(e);
            logger.warn(e.getMessage());
            throw e;
        }

    }

    private void logException(Exception e) {
    }

    @PostMapping("/people")
    public PersonDto addPerson(@RequestBody PersonDto personDto) throws Exception {
        PersonDto person = null;
        try {
            logger.info("addPerson started");
            person = personservice.addPerson(personDto);
        } catch (EntityExistsException e) {
            System.out.println(e.getMessage());
            throw new Exception();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        return person;
    }

    @GetMapping("/people/{id}")
    public PersonDto getPersonById(@PathVariable Long id) throws Exception {

        PersonDto person = null;
        try {
            logger.info("getPersonByUID started");
            person = personservice.getPersonById(id);

            if (person != null) {
                logger.info("getPersonByUID compeleted");
                return person;
            } else {
                logger.info("getPersonByUUID NULL.............");
                return person;
            }
        } catch (Exception e) {
            logException(e);
            logger.warn(e.getMessage());
            throw e;
        }

    }

    @PutMapping("/people/{id}")
    public PersonDto updatePersonById(@PathVariable Long id, @RequestBody PersonDto personDto) throws Exception {

        return personservice.updatePersonById(id, personDto);
    }

    @DeleteMapping("/people/{id}")
    public void deletePersonById(@PathVariable Long id) {
        try {
            logger.info("getPersonByUID compeleted");
            personservice.deletePersonById(id);
            logger.info("getPersonByUID compeleted");

        } catch (Exception e) {
            logException(e);
            logger.warn(e.getMessage());
            throw e;
        }
    }
}
