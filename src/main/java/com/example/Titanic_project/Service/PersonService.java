package com.example.Titanic_project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Titanic_project.Database.Entities.Person;
import com.example.Titanic_project.Database.Repository.personRepository;
import com.example.Titanic_project.api.v1.person.Dto.PersonDto;

@Service
public class PersonService {

    @Autowired
    private personRepository personrepository;
   

    public List<Person> getAllPersons() {

        return personrepository.findAll();

    }

    public PersonDto addPerson(PersonDto personDto) {

        Person person = new Person();

        person.setAge(personDto.getAge());
        person.setName(personDto.getName());
        person.setParentsOrChildrenAboard(personDto.getParentsOrChildrenAboard());
        person.setSiblingsOrSpousesAboard(personDto.getSiblingsOrSpousesAboard());
        person.setFare(personDto.getFare());
        person.setPassengerClass(personDto.getPassengerClass());
        person.setSurvived(personDto.isSurvived());

        Person savedPerson = personrepository.save(person);

        personDto.setId(savedPerson.getId());

        return personDto;

    }

    public PersonDto getPersonById(Long id) {
        Optional<Person> personOp = personrepository.findById(id);
        Person person = personOp.get();

        PersonDto personDto = new PersonDto();

        personDto.setId(person.getId());
        personDto.setAge(person.getAge());
        personDto.setFare(person.getFare());
        personDto.setName(person.getName());
        personDto.setParentsOrChildrenAboard(person.getParentsOrChildrenAboard());
        personDto.setPassengerClass(person.getPassengerClass());
        personDto.setSurvived(person.isSurvived());
        personDto.setSiblingsOrSpousesAboard(person.getSiblingsOrSpousesAboard());
       

        return personDto;

    }

    public PersonDto updatePersonById(Long id,PersonDto personDto) throws Exception {

        Optional<Person> personOp = personrepository.findById(id);
       Person person1 = personOp.get();


      PersonDto personDto1 = new PersonDto();

        personDto1.setAge(person1.getAge());
        personDto1.setFare(person1.getFare());
        personDto1.setName(person1.getName());
        personDto1.setParentsOrChildrenAboard(person1.getParentsOrChildrenAboard());
        personDto1.setPassengerClass(person1.getPassengerClass());
        personDto1.setSiblingsOrSpousesAboard(person1.getSiblingsOrSpousesAboard());
        personDto1.setSurvived(person1.isSurvived());

        Person person = new Person();

        person.setAge(personDto.getAge());
        person.setName(personDto.getName());
        person.setParentsOrChildrenAboard(personDto.getParentsOrChildrenAboard());
        person.setSiblingsOrSpousesAboard(personDto.getSiblingsOrSpousesAboard());
        person.setFare(personDto.getFare());
        person.setPassengerClass(personDto.getPassengerClass());
        person.setSurvived(personDto.isSurvived());
        
         personrepository.save(person);

       
        return personDto;
       

    }

    public void deletePersonById(Long id)  {
        personrepository.deleteById(id);
    }

}
