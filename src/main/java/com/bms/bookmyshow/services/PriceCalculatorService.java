package com.bms.bookmyshow.services;

import com.bms.bookmyshow.models.Show;
import com.bms.bookmyshow.models.ShowSeat;
import com.bms.bookmyshow.models.ShowSeatType;
import com.bms.bookmyshow.repositories.ShowSeatTypeRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {
    private ShowSeatTypeRepository showSeatTypeRepository;
    int amount =0;

    public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int calculatePrice (List<ShowSeat> showSeats, Show show){
        /*
            1) First get the type of seat form ShowSeat --> Seat --> type
            Lets say we want to book 2 Gold type Seat and 2 Silver Type Seat.
            Then calculate price according to it.

            2) Get price of each type of showSeatType
         */

        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        /*
         <123,1> --> Type is GOLD --> Find price of GOLD seat from ShowSeatType
         <123,2>
         <123,3>
         <123,4>
         */

        for(ShowSeat showSeat: showSeats){
            for(ShowSeatType showSeatType: showSeatTypes){ // 1 Seat will match to 1 ShowSeatType
                if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    amount+= showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }
}
