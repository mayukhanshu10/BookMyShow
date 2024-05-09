package com.bms.bookmyshow.services;

import com.bms.bookmyshow.exceptions.InvalidShowException;
import com.bms.bookmyshow.exceptions.InvalidUserException;
import com.bms.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.bms.bookmyshow.models.*;
import com.bms.bookmyshow.repositories.ShowRepository;
import com.bms.bookmyshow.repositories.ShowSeatRepository;
import com.bms.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculatorService priceCalculatorService;

    //Using dependency Injection
    public BookingService(UserRepository userRepository, ShowSeatRepository showSeatRepository, ShowRepository showRepository, PriceCalculatorService priceCalculatorService) {
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
        this.priceCalculatorService = priceCalculatorService;
    }

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

        /*Implement Booking Logic Multiple people should not be able to book same seat at same time.
          That is concurrency Locking technique
         */

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

        /*
            What is Optional<User> ?
            It says User may be present in Db or it can be null.
            Optional is kind of bucket
         */

        //STEP 1
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new InvalidUserException("User is not found in DB");
        }
        User bookedUser = optionalUser.get();

        //STEP 2
        Optional<Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isEmpty()){
            throw new InvalidShowException("Show is Invalid in DB");
        }
        Show bookedShow = optionalShow.get();

        //STEP 3
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        //STEP 4 Check if all Seats are available or not:
        //STEP 4.1 If not, throw an exception

        for(ShowSeat showSeat: showSeats){
            if(showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new ShowSeatNotAvailableException("Show Seat with id: " + showSeat.getId()+" is not available");
            }
        }

        //STEP 4.2 If Yes, mark show seat status as blocked
        for(ShowSeat showSeat: showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            //STEP 5 Save Status in DB
            showSeatRepository.save(showSeat);
        }

        //STEP 6 Create the Booking
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.IN_PROGRESS);
        booking.setUser(bookedUser);
        booking.setPayments(new ArrayList<>());
        booking.setBookedDate(new Date());
        booking.setShowSeats(showSeats);

        //We should Create another Class to calculate price calculator
        booking.setAmount(priceCalculatorService.calculatePrice(showSeats,bookedShow));

        return booking;
    }
}
