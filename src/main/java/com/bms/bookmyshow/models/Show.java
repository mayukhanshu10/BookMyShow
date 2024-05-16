package com.bms.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity(name = "shows") // Show is a reserved keyword in MySQL.
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Screen screen;
    private Date startTime;
    private Date endTime;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}


/*

@Enumerated(EnumType.ORDINAL)
@ElementCollection
private List<Feature> features;

@Enumerated(EnumType.ORDINAL)-> Tells JPA that this is an ENUM column and store numeric ids inplace of original ENUM value
@ElementCollection- Tells JPA that it is collection of ENUMs

 */