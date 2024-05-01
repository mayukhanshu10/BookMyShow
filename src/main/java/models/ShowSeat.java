package models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{

    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
}

/*
Let's Understand Show-Seat Object, It is mapping between Show and Seat
[id: 2 , show: 1, seat: 2, BOOKED]
[id: 3,  show: 1, seat: 3, BOOKED]
[id: 4 , show: 1, seat: 4, BLOCKED]
[id: 5 , show: 1, seat: 5, AVAILABLE]

Observe, 1 show-seat object has 1 seat mapped to it.
But 1 show is mapped to many show seat object cauz each show has many seats
1-----------> 1
showseat-----show => M:1
M <------  1

In above example we can see that for 1 Show, having show-seat id : 2, we can have multiple seats with different seatSatus
 */