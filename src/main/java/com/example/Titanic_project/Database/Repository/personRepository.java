package com.example.Titanic_project.Database.Repository;


import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.example.Titanic_project.Database.Entities.Person;


@Repository
public interface personRepository extends JpaRepositoryImplementation<Person,Long> {
    
}
