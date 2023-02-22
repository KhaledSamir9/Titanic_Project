package com.example.Titanic_project.api.v1.person.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class PersonDto {
    
    private Long id;
    
    private boolean survived;

    private Integer passengerClass;

    private String Name;

    private String sex;

    private int age;
     
    private Integer siblingsOrSpousesAboard;
 
    private Integer parentsOrChildrenAboard;

    private int fare;


}
