package dtos;

import lombok.Getter;
import lombok.Setter;
import models.BookingResponseStatus;

@Getter
@Setter
public class BookMovieResponseDto {
    private Long bookingId;
    private BookingResponseStatus bookingResponseStatus;
    private int amount;
}
