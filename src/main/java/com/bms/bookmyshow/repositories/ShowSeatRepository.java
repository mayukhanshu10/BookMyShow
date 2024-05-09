package com.bms.bookmyshow.repositories;

import com.bms.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {

    @Override
    List<ShowSeat> findAllById(Iterable<Long> showSeatIds);
    //Find All the showseats by the ShowSeatIds. These are the seats requested by User for particular Show


    @Override
    ShowSeat save(ShowSeat showSeat);
    /* 1)If ShowSeat Obj we passing in input, isn't there in Db then Insert it into DB
         If show seat Object contains no Id that means it is not in DB therefore, Insert in DB
       2)If ShowSeat obj is present, then update the object in DB
     */


}
