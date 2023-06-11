package com.anabank.anabank.repository;

import com.anabank.anabank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/* provide methods for talking to database.
    manipulates the user table and its corresponding entity
    by referencing the primary key id(Long)
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existByEmail(String email);

}
