package com.bms.bookmyshow.repositories;

import com.bms.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    /*
        JPA Repository : It provides multiple inbuilt queries which are generalised.
     */

    //Find the user by the given userId
    //This will also take query internally to return user object when provided userId
    @Override
    Optional<User> findById(Long userId);

    /*
        This will internally do something like :
        Select * From Users where userIds in (1,2,3,4,5....)
     */
    @Override
    List<User> findAllById(Iterable<Long> userIds);
}
