package com.bms.bookmyshow.exceptions;

public class ShowSeatNotAvailableException extends RuntimeException{
    public ShowSeatNotAvailableException(String message){
        super(message);
    }
}
