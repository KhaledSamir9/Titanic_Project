package com.example.Titanic_project.Database.Entities;



import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter


@Table(name = "People")
@Entity
public class Person {
    

  @Id
  @GeneratedValue
  private long id;

  private boolean survived;
  
  private String name;
   
  private Integer passengerClass;

  private Integer siblingsOrSpousesAboard;
 
  private Integer parentsOrChildrenAboard;

  private int age;

  private int fare;

  @Enumerated(EnumType.STRING)
  private Sex sex;

public void setPerson(Person person1) {
}


  


}
