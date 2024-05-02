package com.bms.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{ // It is a ticket class

    @ManyToOne
    private User user;
    @ManyToMany
    private List<ShowSeat> showSeats;
    private int amount;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    private Date bookedDate;
    @OneToMany
    private List<Payment> payments;

}

/*
 1----->M
 Booking---ShowSeat
 M <------ M
 why M to M : cauz suppose I booked ticket for a seat and then cancelled, same seat can be booked by other person too. That is why M to M


 1-------------> M
 Booking ----Payment => 1:M
 1 <---------- 1


 */
