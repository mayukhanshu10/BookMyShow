package com.bms.bookmyshow.services;

import com.bms.bookmyshow.models.Booking;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingService {

    /*
     Here We return Booking object and BookingResponseDto cauz this service can be called by many Controllers having different-different DTOs.
     Therefore we donot tightcouple service method with any return type dtos
     */

    /*
      In java code, we use synchronized keyword to take lock on particular method, but this synchronized will
      not work in DB part. We have to use something that works in DB transaction to take lock.
      @Transactional: works for that
     */

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, Long showId, List<Long> showSeatIds){

        //Multiple people should not be able to book same seat at same time. That is concurrency Locking technique

        /*
        Implement Booking Logic
        1) Fetch User from Db using userId
        2) Fetch show from DB using showId
        3) Get the list of showSeats from showSeatIds from DB
        4) Check If All seats Available or not
        ------------ACQUIRE LOCK -------------
        4.1) If Not, Throw an exception
        4.2) If yes, Mark the status as BLOCKED.
        5) Save the status of seat in DB as well
        ------------RELEASE LOCK -------------
        6) Create Booking Object.
        7) Save the Booking to Db
        8) Return the booking

        Now , In Springboot, acquiring lock at any midpoint in code is difficult task. Therefore, we will move ahead
        with the FIRST approach and Lock whole method of booking (cauz lock whole method is very easy task in Spring Boot)

         */




        return null;


        //Implement Booking Logic
        //Multiple people should not be able to book same seat at same time. That is concurrency Locking technique




    }
}
