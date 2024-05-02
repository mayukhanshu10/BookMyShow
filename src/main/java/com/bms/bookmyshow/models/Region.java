package com.bms.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/*
@Entity is used to tell JPA that create a table in DB for this Class
@Id will make that attribute primary key of every table
@GeneratedValue(strategy = GenerationType.AUTO) : This will increment primary id by 1 each time like 1,2,3,4,5.........
 */



@Getter
@Setter
@Entity
public class Region extends BaseModel{

    private String name;

//    List<Theater> theaters; (Can be put into Theater class)

}
