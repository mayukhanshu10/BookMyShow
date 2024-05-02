package com.bms.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theater extends BaseModel{
    private String nameTheater;
    @ManyToOne
    private Region region;
    @OneToMany
    List<Screen> screens;
}

/*
We find Cardinality for Non-Primitive Attributes
Eg: Cardinality between Theater and region
Cardinality between Theater and Screen
1----->1
theater--region =>M:1
M<-----1

Similarliy
Theater:Screen => 1:M
 */