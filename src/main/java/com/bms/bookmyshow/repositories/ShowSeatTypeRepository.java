package com.bms.bookmyshow.repositories;

import com.bms.bookmyshow.models.Show;
import com.bms.bookmyshow.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {

    List<ShowSeatType> findAllByShow(Show show);
}
