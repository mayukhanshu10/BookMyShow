package com.bms.bookmyshow.services;

import com.bms.bookmyshow.models.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    //Here We return Booking object and BookingResponseDto cauz this service can be called by many Controllers having different-different DTOs.
    //Therefore we donot tightcouple service method with any retun dtos

    public Booking bookMovie(Long userId, Long showId, List<Long> showSeatIds){

        return null;


        //Implement Booking Logic
        //Multiple people should not be able to book same seat at same time. That is concurrency Locking technique




    }
}
