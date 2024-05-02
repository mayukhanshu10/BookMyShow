package com.bms.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;
import com.bms.bookmyshow.models.BookingResponseStatus;

@Getter
@Setter
public class BookMovieResponseDto {
    private Long bookingId;
    private BookingResponseStatus bookingResponseStatus;
    private int amount;
}
