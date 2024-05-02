package com.bms.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{
    @ManyToOne
    private Show show;
    private SeatType seatType;
    private int price;
}


/*

[id:1 , show: 1, GOLD]
[id:2 , show: 1, PLATINUM]
[id:3 , show: 1, DIAMOND]
[id:4 , show: 1, SILVER]

1-------->1
ShowSeatType ------------ show
M  <------ 1

 */
