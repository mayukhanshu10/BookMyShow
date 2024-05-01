package services;

import models.Booking;

import java.util.List;

public class BookingService {

    //Here We return Booking object and BookingResponseDto cauz this service can be called by many Controllers having different-different DTOs.
    //Therefore we donot tightcouple service method with any retun dtos

    public Booking bookMovie(Long userId, Long showId, List<Long> showSeatIds){
        return null;
    }
}
