package com.bms.bookmyshow.controllers;

import com.bms.bookmyshow.dtos.BookMovieRequestDto;
import com.bms.bookmyshow.dtos.BookMovieResponseDto;
import com.bms.bookmyshow.models.Booking;
import com.bms.bookmyshow.models.BookingResponseStatus;
import com.bms.bookmyshow.services.BookingService;

public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    public BookMovieResponseDto bookMovie(BookMovieRequestDto bookMovieRequestDto){
        BookMovieResponseDto bookMovieResponseDto = new BookMovieResponseDto();



        return null;
    }
}
