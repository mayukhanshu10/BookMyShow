package com.bms.bookmyshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookmyshowApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookmyshowApplication.class, args);
    }

    /*

    Client -> BMS API's

    Client --> Booking Controller --> Services --> ......

     */

}
