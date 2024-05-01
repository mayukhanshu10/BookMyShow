package controllers;

import dtos.BookMovieRequestDto;
import dtos.BookMovieResponseDto;
import models.Booking;
import models.BookingResponseStatus;
import models.BookingStatus;
import services.BookingService;

import java.util.List;

public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    public BookMovieResponseDto bookMovie(BookMovieRequestDto bookMovieRequestDto){
        BookMovieResponseDto bookMovieResponseDto = new BookMovieResponseDto();

        try{
            Booking booking = bookingService.bookMovie(bookMovieRequestDto.getUserId(),bookMovieRequestDto.getShowId(),bookMovieRequestDto.getShowSeatIds());

            bookMovieResponseDto.setBookingId(booking.getId());
            bookMovieResponseDto.setAmount(booking.getAmount());
            bookMovieResponseDto.setBookingResponseStatus(BookingResponseStatus.CONFIRMED);
        }catch (Exception exception){
            bookMovieResponseDto.setBookingResponseStatus(BookingResponseStatus.FAILURE);
        }

        return bookMovieResponseDto;
    }
}
