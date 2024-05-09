package com.bms.bookmyshow.repositories;

import com.bms.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {

    @Override
    List<ShowSeat> findAllById(Iterable<Long> showSeatIds);
    //Find All the showseats by the ShowSeatIds. These are the seats requested by User for particular Show
}
